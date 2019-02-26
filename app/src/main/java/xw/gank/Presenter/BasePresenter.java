package xw.gank.Presenter;

import xw.gank.CallBack.IPresenter;
import xw.gank.CallBack.IView;

public abstract class BasePresenter <T extends IView> implements IPresenter<T> {
    protected T mView;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public boolean isViewAttached() {
        return mView != null;
    }
}
