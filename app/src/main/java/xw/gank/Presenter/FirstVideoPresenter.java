package xw.gank.Presenter;

import android.content.Context;

import xw.gank.CallBack.BasePresenterICallBack;
import xw.gank.CallBack.CallBack;
import xw.gank.firstvideocallback.FirstVideoPresenterCallBack;
import xw.gank.model.GetFirstVideoModelData;

public class FirstVideoPresenter extends BasePresenter<BasePresenterICallBack> implements FirstVideoPresenterCallBack {
    private GetFirstVideoModelData firstVideoModelData;

    public FirstVideoPresenter() {
        this.firstVideoModelData = new GetFirstVideoModelData ();
    }
    @Override
    public void getData(Context context, String type, String page) {
        firstVideoModelData.getData(context, type, page, new CallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()){
                    mView.showArticleSuccess(data);
                }
            }

            @Override
            public void onFail(Object data) {
             if (isViewAttached()){
                 mView.showArticleFail((String) data);
             }
            }
        });

    }
//    private GetGankModelData getGankModelData;
//
//    public FirstVideoPresenter() {
//        this.getGankModelData = new GetGankModelData();
//    }

//
//    @Override
//    public void
//    getData(Context context, String type, String page) {
//        getGankModelData.getData(context, count, page, new CallBack() {
//            @Override
//            public void onSuccess(Object data) {
//                if (isViewAttached()) {
//                    mView.showArticleSuccess((GankModel) data);
//                }
//            }
//
//            @Override
//            public void onFail(Object data) {
//                if (isViewAttached()) {
//                    mView.showArticleFail((String) data);
//                }
//            }
//        });
//    }
}
