package xw.gank.retrofit;

import android.support.annotation.NonNull;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xw.gank.model.BaseModel;

/**
 * Created by weihuajian on 16/6/22.
 */
public abstract class BaseCallback<T extends BaseModel> implements Callback<T> {

    @Override
    public void onResponse(@NonNull Call call, Response response) {


        int code = response.raw().code();
        int code1 = response.code();
        Log.i("======code",""+code+code1);

        if (code == 200) {
            Log.i("=========response","response");
            /**
             * 这里我只实现了成功和失败的回调，还可以根据接口返回的状态信息实现相应的回调
             * */
            T t = (T) response.body();
            assert t != null;
            if (!t.isError()) {
                Log.i("=========response1","response");
                onSuccess(t);
            } else {
                /**
                 * 如果接口返回了msg，就不要使用自定义的msg
                 * */
                Log.i("=========response2","response");
                onFail(ERR_MSG.ERROR_NO_RESULT);
            }
        } else if (code == 204) {
            onNoData(ERR_MSG.NO_DATA);
        } else if (code == 400) {
            onFail(ERR_MSG.ERR0E_400);
        } else if (code == 500) {
            onFail(ERR_MSG.ERROR_500);
        } else {
            onFail(ERR_MSG.ERROR_NO_RESULT);
        }

        onAfter();
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.i("=========onFailure","onFailure");
        onFail(t.getMessage());
        onAfter();
    }

    /**
     * 请求成功的回调
     */
    protected abstract void onSuccess(T response);

    /**
     * 请求完的回调，可以在里面停止刷新控件，可以不实现
     */
    private void onAfter() {
    }

    /**
     * 没有数据的回调，可以不实现
     */
    private void onNoData(String msg) {

    }

    /**
     * 请求失败的回调
     */
    protected abstract void onFail(String msg);


    /**
     * 自定义的错误信息
     */
    class ERR_MSG {
        private static final String NO_DATA = "暂无数据";
        private static final String ERR0E_400 = "请求失败";
        private static final String ERROR_500 = "服务器错误";
        private static final String ERROR_NO_RESULT = "未知错误";
    }

}
