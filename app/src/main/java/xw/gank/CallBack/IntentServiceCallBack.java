package xw.gank.CallBack;

import java.util.List;

import xw.gank.info.GirlItemData;

public interface IntentServiceCallBack {
    void intentServiceCallBack(List<GirlItemData> datas);
    void intentServiceCallBack(String string);
}
