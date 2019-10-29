package com.itheima.bp;

import cn.hutool.json.JSONUtil;
import com.itheima.domain.PMData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
 
/**
*空气质量调用示例代码 － 聚合数据
*在线接口文档：http://www.juhe.cn/docs/33
**/
 
public class JuheDemo {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
 
    //配置您申请的KEY
    public static final String APPKEY ="0779c48b04af69292afac4f07a9a67b0";
 
    //1.城市空气质量
    public static void getRequest1(String cityName){
        String result =null;
        String url ="http://web.juhe.cn:8080/environment/air/cityair";//请求接口地址
        Map params = new HashMap();//请求参数
            params.put("city",cityName);//城市名称的中文名称或拼音，如：上海 或 shanghai
            params.put("key",APPKEY);//APP Key
 
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    //2.城市空气PM2.5指数
    public static PMData getRequest2(String cityName){
        PMData pmData =null;
        String result =null;
        String url ="http://web.juhe.cn:8080/environment/air/pm";//请求接口地址
        Map params = new HashMap();//请求参数
            params.put("city",cityName);//城市名称的中文名称或拼音，如：上海 或 shanghai
            params.put("key",APPKEY);//APP Key
 
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                //System.out.println(object.get("result"));
                JSONArray jsonArray=(JSONArray) object.get("result");
                for (Object o : jsonArray) {
                    cn.hutool.json.JSONObject jsonObject = JSONUtil.parseObj(o);
                    String pm25 = (String)jsonObject.get("PM2.5");
                    pmData = JSONUtil.toBean(jsonObject, PMData.class);
                    pmData.setPM25(pm25);
                }
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pmData;
    }
 
    //3.城市空气质量-城市列表
    public static void getRequest3(){
        String result =null;
        String url ="http://web.juhe.cn:8080/environment/air/airCities";//请求接口地址
        Map params = new HashMap();//请求参数
            params.put("key",APPKEY);//APP Key
 
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    //4.城市空气PM2.5指数-城市列表
    public static void getRequest4(){
        String result =null;
        String url ="http://web.juhe.cn:8080/environment/air/pmCities";//请求接口地址
        Map params = new HashMap();//请求参数
            params.put("key",APPKEY);//APP Key
 
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    //5.城市辐射指数
    public static void getRequest5(String cityName){
        String result =null;
        String url ="http://web.juhe.cn:8080/environment/air/radia";//请求接口地址
        Map params = new HashMap();//请求参数
            params.put("city",cityName);//城市名称的中文拼音，查询城市为“上海”，则输入：上海
            params.put("num","");//查询页码数，不写默认为第一页。
            params.put("key",APPKEY);//APP Key
 
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
 
 
    public static void main(String[] args) {
        //getRequest1("xian");
        getRequest2("xian");
    }
 
    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                        out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }
 
    //将map型转为请求参数型
    public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}