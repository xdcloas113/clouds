import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * 所在包：PACKAGE_NAME
 * 文件名：
 * 项目：clouds
 * 功能描述：
 * 修改人：xdc
 * 创建时间：2019-08-22 11:35
 */
public class Test {

    public static void main(String[] args) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();

//        test1();
        String re = "JWT_REFRESH_TOKEN::%s";
        String token= "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJNSU5HIiwiZXhwIjoxNTY3MjE1NDI0LCJ1c2VyTmFtZSI6ImFkbWluIiwiaWF0IjoxNTY3MTI5MDI0fQ.2kRHdmC3IdtysBQEsl2ZyXt195Uvs2N_e797wZnzTDM";
        String format = String.format(re, token);
        Boolean aBoolean = stringRedisTemplate.hasKey(format);
        System.out.println(aBoolean);
    }


    public static void test1 () {
        String[] no_filter = new String [2];
        no_filter[0] = "/chient-a/**";
        no_filter[1] = "/chient-c/**";
        String urls = "/chient-c/asdfsad/asdad/";

        String s = StrUtil.subBetween(urls, "/", "/");

        if (contains(no_filter, s)) {
            System.out.println("返回了？");
        } else {
            System.out.println("我去");
        }
    }

    public static boolean contains(String[] array, String value) {
        return indexOf(array, value) > -1;
    }

    public static int indexOf(String[] array, String value) {
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].contains(value)) {
                    return i;
                }
            }
        }
        return -1;
    }

}
