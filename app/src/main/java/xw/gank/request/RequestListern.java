package xw.gank.request;

/**
 * 登录界面的接口
 */

public interface RequestListern {
    void  OnSucess(String string);
    void OnError(Exception error);

}
