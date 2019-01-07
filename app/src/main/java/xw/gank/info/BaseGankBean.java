package xw.gank.info;

import java.io.Serializable;

class BaseGankBean implements Serializable {
    private boolean error;
    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
