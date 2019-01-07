package xw.gank.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by weihuajian on 16/6/22.
 * 公共的响应体，可以根据自身项目接口的json结构自己定义
 */
public class BaseModel<T> implements Serializable {

    public boolean isError() {
        return error;
    }

    private boolean error;

    public void setError(boolean error) {
        this.error = error;
    }
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
