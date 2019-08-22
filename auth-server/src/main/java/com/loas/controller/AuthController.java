package com.loas.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
public class AuthController {

    @Value("${jwt.secret.key}")
    private String secretKey;

    private long tokenExpireTime;

    @Value("${token.expire.time}")
    public void setTokenExpireTime(long tokenExpireTime) {
        this.tokenExpireTime = tokenExpireTime;
    }

    private long refreshTokenExpireTime;

    @Value("${refresh.token.expire.time}")
    public void setRefreshTokenExpireTime(long refreshTokenExpireTime) {
        this.refreshTokenExpireTime = refreshTokenExpireTime;
    }

    @Value("${jwt.refresh.token.key.format}")
    private String jwtRefreshTokenKeyFormat;

    @Value("${jwt.blacklist.key.format}")
    private String jwtBlacklistKeyFormat;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 登录授权，生成JWT
     * 这里就需要查询数据库但是现在为了方便 直接admin/admin 完事
     *
     * @param userName
     * @param password
     * @return
     */
    @PostMapping("/auth/login")
    @ResponseBody
    public Map<String, Object> login(@RequestParam("userName") String userName,
                                     @RequestParam("password") String password) {
        Map<String, Object> resultMap = new HashMap<>();
        //账号密码校验
        if (StringUtils.equals(userName, "admin") &&
                StringUtils.equals(password, "admin")) {

            //生成JWT
            String token = buildJWT(userName);
            //生成refreshToken
            String refreshToken = UUID.randomUUID().toString().replaceAll("-", "");
            //保存refreshToken至redis，使用hash结构保存使用中的token以及用户标识
            String refreshTokenKey = String.format(jwtRefreshTokenKeyFormat, refreshToken);
            stringRedisTemplate.opsForHash().put(refreshTokenKey,
                    "token", token);
            stringRedisTemplate.opsForHash().put(refreshTokenKey,
                    "userName", userName);
            //refreshToken设置过期时间
            stringRedisTemplate.expire(refreshTokenKey,
                    refreshTokenExpireTime, TimeUnit.MILLISECONDS);
            //返回结果
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("token", token);
            dataMap.put("refreshToken", refreshToken);
            resultMap.put("code", "10000");
            resultMap.put("data", dataMap);
            return resultMap;
        }
        resultMap.put("isSuccess", false);
        return resultMap;
    }

    /**
     * 刷新JWT
     *
     * @param refreshToken
     * @return
     */
    @PostMapping("/token/refresh")
    @ResponseBody
    public Map<String, Object> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        Map<String, Object> resultMap = new HashMap<>();
        String refreshTokenKey = String.format(jwtRefreshTokenKeyFormat, refreshToken);
        String userName = (String) stringRedisTemplate.opsForHash().get(refreshTokenKey,
                "userName");
        if (StringUtils.isBlank(userName)) {
            resultMap.put("code", "10001");
            resultMap.put("msg", "refreshToken过期");
            return resultMap;
        }
        String newToken = buildJWT(userName);
        //替换当前token，并将旧token添加到黑名单
        String oldToken = (String) stringRedisTemplate.opsForHash().get(refreshTokenKey,
                "token");
        stringRedisTemplate.opsForHash().put(refreshTokenKey, "token", newToken);
        stringRedisTemplate.opsForValue().set(String.format(jwtBlacklistKeyFormat, oldToken), "",
                tokenExpireTime, TimeUnit.MILLISECONDS);
        //生成refreshToken
        resultMap.put("code", "10000");
        resultMap.put("data", newToken);
        resultMap.put("refreshToken", refreshToken);
        return resultMap;
    }

    private String buildJWT(String userName) {
        //生成jwt
        Date now = new Date();
        Algorithm algo = Algorithm.HMAC256(secretKey);
        String token = JWT.create()
                .withIssuer("MING")
                .withIssuedAt(now)
                .withExpiresAt(new Date(now.getTime() + tokenExpireTime))
                .withClaim("userName", userName)//保存身份标识
                .sign(algo);
        return token;
    }

    @RequestMapping("/auth/get")
    @ResponseBody
    public String getIndex () {
        return "直接放行哈";
    }

    @RequestMapping("/auth/get1")
    @ResponseBody
    public String getIndex2 () {
        System.out.println("这里是要认证了才能进入");
        return "需要认证才看的到";
    }

}