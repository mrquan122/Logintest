package net;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/5 0005.
 */
public class RequestManager {

    private List requestList = new ArrayList();


    public void addRequest(HttpRequest request){
        requestList.add(request);
    }

    public void cancelRequest(){
        if((requestList !=null)&&(requestList.size()>0)){
            for (final HttpRequest request :requestList){
                if(request.getRequest()!=null){
                    try{
                        request.getRequest().abort();
                        requestList.remove(request.getRequest());
                    }catch (final UnsupportedOperationException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
