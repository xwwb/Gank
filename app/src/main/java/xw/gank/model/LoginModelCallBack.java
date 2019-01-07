package xw.gank.model;

import xw.gank.callback.CallBack;
import xw.gank.callback.IModel;

public interface LoginModelCallBack extends IModel {
    void  login(String count, String password, CallBack callBack);

}
