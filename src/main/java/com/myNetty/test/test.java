package com.myNetty.test;


import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class test {
    public static void main(String[] args) throws Exception {
        String urls = "http://localhost:8080";
        URL url = new URL(urls);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.addRequestProperty("Connection","Keep-Alive");//设置与服务器保持连接
        connection.setRequestProperty("Accept-Language", "zh-CN,zh;0.9");

    }
}
