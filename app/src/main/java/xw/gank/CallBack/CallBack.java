package xw.gank.CallBack;

public interface CallBack<K,V> {
    void onSuccess(K data);
    void onFail(V data);
}
