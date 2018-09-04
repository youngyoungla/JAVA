import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
/**
 * Created by zhao on 2018/9/3.
 */

public class SimpleClient {
    public static void main(String[] args)throws IOException
    {
        CloseableHttpClient client = HttpClients.createDefault();
        //设置代理服务器地址和端口
        //client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
        //使用GET方法，如果服务器需要通过 HTTPS连接，只需要改成HTTPS
        HttpGet request =new HttpGet("http://www.baidu.com/"); //创建httpget实例
        CloseableHttpResponse response=null;
        try
        {
            response=client.execute(request); //执行http get请求
        }
        catch (ClientProtocolException e) //http协议异常
        {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        HttpEntity entity=response.getEntity(); //获取返回实体
        try
        {
            System.out.println("网页内容："+ EntityUtils.toString(entity,"utf-8")); //获取网页内容
        }
        catch(ParseException e)//解析异常
        {
            e.printStackTrace();
        }
        catch (IOException e)// io 异常
        {
            e.printStackTrace();

        }
        response.close();
        client.close();

    }
}
