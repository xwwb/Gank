package xw.gank.model;

import xw.gank.CallBack.CallBack;
import xw.gank.CallBack.IModel;

public interface LoginModelCallBack extends IModel {
    void  login(String count, String password, CallBack callBack);

}
