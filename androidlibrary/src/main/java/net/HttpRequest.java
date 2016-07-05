package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/5 0005.
 */
public class HttpRequest implements Runnable {

    @Override
    public void run() {

    URLData urlData= new URLData();
     String url = urlData.url;
    private static String send(String url,String method,
                               Map<String,String> parameters,Map<String,String> propertys) throws Exception{

        HttpURLConnection urlConnection = null;

        if(method.equalsIgnoreCase("GET") && parameters != null){
            StringBuffer param = new StringBuffer();
            int i = 0;
            for(String key : parameters.keySet()){
                if(i == 0) param.append("?");
                else param.append("&");
                param.append(key).append("=").append(parameters.get(key));
                i++;
            }
            url += param;
        }
        URL mUrl=new URL(url);
        // 根据url生成urlConnection对象
        urlConnection = (HttpURLConnection) mUrl.openConnection();

        // 设置参数
        urlConnection.setRequestMethod(method);
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        urlConnection.setUseCaches(false);
        if(propertys != null){
            for(String key : propertys.keySet()){
                urlConnection.addRequestProperty(key, propertys.get(key));
            }
        }

        if(method.equalsIgnoreCase("POST") && parameters != null){
            StringBuffer param = new StringBuffer();
            for(String key : parameters.keySet()){
                param.append("&");
                param.append(key).append("=").append(parameters.get(key));
            }
            urlConnection.getOutputStream().write(param.toString().getBytes());
            urlConnection.getOutputStream().flush();
            urlConnection.getOutputStream().close();
        }
        return makeContent(url,urlConnection);
    }
    private static String makeContent(String urlString,HttpURLConnection urlConnection)
            throws IOException {
        InputStream in = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        StringBuffer temp = new StringBuffer();
        String line;
        while((line = bufferedReader.readLine()) != null){
            temp.append(line);
        }
        bufferedReader.close();
        return temp.toString();
    }


   if (responseInJson.hasError()){
        handleNetworkError(responseInJson.getErrorMessage());
    }else {
        handler.post(new Runnable(){
            @Override
            public void run(){
                HttpRequest.this.requestCallback.onSuccess(responseInJson,getResult());
            }
        } );

     }

    if(urlData.getExpires()>0){
    final String content =CacheManager.getInstance().getFileCache(newUrl);
        if(content!=null){
            handler.post(new Runnable(){
                @Override
                public void run(){
                    requestCallback.onSuccess(content);
                }
            });
            return;
        }
    }
}



