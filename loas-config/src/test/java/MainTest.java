import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 所在包：PACKAGE_NAME
 * 文件名：
 * 项目：Spring-cloud-All
 * 功能描述：
 * 修改人：xdc
 * 创建时间：2019-01-11 17:27
 * 测试密钥
 */
public class MainTest {
    public static void main(String[] args) throws Exception{
//        createCode();
        analysisCode();
    }

    private static void analysisCode() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        // 发送post请求
        HttpPost post = new HttpPost("http://localhost:8888/decrypt");

        // 设置请求的参数，对2cdf324e7d8c6271d883a7a9bdcac532d027141545f1fed273f8c2b803bc3e9d进行解密，编码格式为UTF-8
        HttpEntity entity = new StringEntity("5e73699a-11a0-49da-97c7-b352e9d0041c", Consts.UTF_8);
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    private static void createCode() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        // 发送post请求
        HttpPost post = new HttpPost("http://localhost:8888/encrypt");

        // 设置请求的参数，对20180323进行加密，编码格式为UTF-8
        HttpEntity entity = new StringEntity("loas", Consts.UTF_8);
        post.setEntity(entity);

        HttpResponse response =  client.execute(post);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }


}
