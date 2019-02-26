package xw.gank.utils;

import java.util.List;

import xw.gank.CallBack.IntentServiceCallBack;
import xw.gank.info.GirlItemData;

public class CallBackUtils {
    public static IntentServiceCallBack intentServiceCallBack;

    /**
     * @param intentServiceCallBack
     */
    public static void setIntentServiceCallBack(IntentServiceCallBack intentServiceCallBack) {
        CallBackUtils.intentServiceCallBack = intentServiceCallBack;
    }
    public static void finActivity(String string ,List<GirlItemData>data){
        if (intentServiceCallBack !=null){
            intentServiceCallBack.intentServiceCallBack(data);
            intentServiceCallBack.intentServiceCallBack(string);
        }
    }
}
