package xw.gank.model;

import android.content.Context;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import xw.gank.CallBack.CallBack;
import xw.gank.firstvideocallback.FirstVideoModelCallBack;
import xw.gank.info.FirstVideoBean;
import xw.gank.retrofit.ApiService;
import xw.gank.retrofit.RetrofitUtils;

public class GetFirstVideoModelData implements FirstVideoModelCallBack {

    @Override
    public void getData(Context context, String type, String page, final CallBack callBack) {
        RetrofitUtils.getFirstVideoInstance(context).create(ApiService.class).getFirstVideo(type, page).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FirstVideoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FirstVideoBean firstVideoBean) {
                        if (null == firstVideoBean) {
                            callBack.onFail("");
                        } else if (firstVideoBean.getCode() != 200) {
                            callBack.onFail("未知错误");
                        } else {
                            callBack.onSuccess(firstVideoBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
