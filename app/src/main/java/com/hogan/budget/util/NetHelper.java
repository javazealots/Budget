package com.hogan.budget.util;

import com.hogan.budget.base.bean.GlobalXML;
import com.hogan.budget.base.global.GlobalContext;
import com.hogan.budget.type.ResourceType;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Created by Hogan on 9/5/2016.
 * 联网帮助类
 */
public class NetHelper {

    private GlobalContext globalContext = GlobalContext.newInstance();
    private GlobalXML globalXML = (GlobalXML) globalContext.getGlobalResource().getResource(ResourceType.GLOBAL);

    public static void request(String remoteUrl, String requestMethod, Map<String, String> params) {
        URL url = null;//请求的URL地址
        HttpURLConnection conn = null;
        byte[] requestBody = null;//请求体
        byte[] responseBody = null;//响应体
        try {
            url = new URL(remoteUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(requestMethod);
            //调用conn.setDoOutput()方法以显式开启请求体
            conn.setDoOutput(true);
            //获取conn的输出流
            OutputStream os = conn.getOutputStream();
            //设置请求参数
            if (params != null) {
                String postParams = "";
                for (Map.Entry<String, String> ele : params.entrySet()) {
                    postParams += ele.getKey() + "=" + ele.getValue() + "&";
                }
                requestBody = new String(postParams.substring(0, postParams.length() - 1)).getBytes("UTF-8");
            }
            os.write(requestBody);
            os.flush();
            os.close();
            //当调用getInputStream方法时才真正将请求体数据上传至服务器
            InputStream is = conn.getInputStream();
            //获得响应体的字节数组
            responseBody = getBytesByInputStream(is);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //从InputStream中读取数据，转换成byte数组，最后关闭InputStream
    private static byte[] getBytesByInputStream(InputStream is) {
        byte[] bytes = null;
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(baos);
        byte[] buffer = new byte[1024 * 8];
        int length = 0;
        try {
            while ((length = bis.read(buffer)) > 0) {
                bos.write(buffer, 0, length);
            }
            bos.flush();
            bytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bytes;
    }

}
