package com.lyh.testdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lyh on 2017/1/18.
 */

/**
 * @author Jasonzhou
 * @功能 读取网页内容
 * @说明 获取网页的全部代码后使用jsuop进行处理， 以便得到想要的内容
 * @since 2013-03-21
 **/

public class TestActivity extends Activity {
    // 指定网页地址
    public String baseurl = "http://blog.csdn.net/jasonzhou613/article/details/7905388";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        URL url = null;
        try {
            url = new URL(baseurl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        manageException();// 处理抛出异常
        TextView tv = (TextView) findViewById(R.id.text);
        String myString = null;
        myString = posturl(url);
        // 设置屏幕显示
        Log.i("---网页代码---", "" + myString);
        String html = myString;
        Document doc = Jsoup.parse(html);
        //tv.setText(doc.title());

    }

    /**
     * 获取参数指定的网页代码，将其返回给调用者，由调用者对其解析 返回String
     *
     * @param url
     */
    public String posturl(final URL url) {
        InputStream is = null;
        String result = "";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000); //设置连接超时
                    connection.setReadTimeout(8000);    //读取超时的毫秒数
                    int status_code = connection.getResponseCode();
                    if (status_code == 200) {
                        InputStream in = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                        Log.i("1111", "posturl: " + response.toString());
                    }

                } catch (Exception e) {

                }
            }
        }).start();


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "utf-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();

            result = sb.toString();
        } catch (Exception e) {
            return "Fail to convert net stream!";
        }

        return result;
    }

    public void manageException() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork() // or
                // .detectAll()
                // for
                // all
                // detectable
                // problems
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
                .build());
    }


}


