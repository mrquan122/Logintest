package net;

import android.app.Activity;

/**
 * Created by Administrator on 2016/7/5 0005.
 */
public class UrlConfigManager {
    public static URLData findURL(final Activity activity,final String findKey){
        if (urlList==null ||urlList.isEmpty())
            fetchUrlDataFromXml(activity);
        for(URLData data :urlList){
            if(findKey.equals(data.getKey())){
                return  data ;
            }
        }
        return  null;
    }
}
