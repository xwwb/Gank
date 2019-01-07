package xw.gank.info;

/**
 * Created by Administrator on 2018/5/28.
 */

public class NoDataBean {

    /**
     * msg : rate_limit_exceeded2: 42.92.188.124
     * code : 112
     * request : GET /v2/movie/search
     */

    private String msg;
    private int code;
    private String request;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
