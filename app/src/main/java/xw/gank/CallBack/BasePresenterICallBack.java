package xw.gank.CallBack;

public interface BasePresenterICallBack<T> extends IView {

    void showArticleSuccess(T result);

    void showArticleFail(String errorMsg);

}
