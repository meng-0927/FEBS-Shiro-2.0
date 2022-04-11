package cc.mrbird.febs.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestUtils {
    private static final int connectTimeout = 300000;
    private static final int socketTimeout = 100000;


    public static JSONObject sendPostJson(String url, String json) throws IOException {

        HttpPost httpPost = new HttpPost(url);
        StringEntity postEntity = new StringEntity(json, "UTF-8");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(postEntity);
        //设置请求器的配置
        RequestConfig requestConfig = RequestConfig.custom().
                setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
        httpPost.setConfig(requestConfig);

        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, "UTF-8");
//        System.out.println("$$$$$$$$$$=>"+result);
        return JSONObject.parseObject(result);
    }

    public static JSONObject sendGet(String urlParam) throws IOException {
        // 创建httpClient实例对象
        HttpGet httpGet = new HttpGet(urlParam);
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        RequestConfig requestConfig = RequestConfig.custom().
                setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
        httpGet.setConfig(requestConfig);

        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, "UTF-8");
        return JSONObject.parseObject(result);
    }

    public static String httpRequest(String reqUrl, String method, String content) throws Exception {
        URL url;
        // 打开和URL之间的连接
        url = new URL(reqUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("content-type", "application/json");
        // Read from the connection. Default is true.
        connection.setDoInput(true);
        // Set the post method. Default is GET
        connection.setRequestMethod(method);
        // Post cannot use caches
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        // The URL-encoded contend
        out.write(content.getBytes("UTF-8"));
        out.flush();
        out.close(); // flush and close
        // 定义 BufferedReader输入流来读取URL的响应
        BufferedReader reader = new BufferedReader
                (new InputStreamReader(connection.getInputStream(), "utf-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        connection.disconnect();

        return sb.toString();
    }
}
