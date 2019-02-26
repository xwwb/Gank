package xw.gank.firstvideocallback;

import android.content.Context;

import xw.gank.CallBack.CallBack;
import xw.gank.CallBack.IModel;

public interface FirstVideoModelCallBack extends IModel {
    void getData(Context context, String  type, String page, CallBack callBack);
}
