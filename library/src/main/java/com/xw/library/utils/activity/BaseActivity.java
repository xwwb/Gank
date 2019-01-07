package com.xw.library.utils.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.xw.library.utils.utils.LoadingDailog;

public abstract class BaseActivity extends AppCompatActivity {

    protected ImmersionBar immersionBar;
    private LoadingDailog dialog;
    private LoadingDailog.Builder builder;
    private Toast toast;
    protected Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDailog();
        context=this;
        setStatusBar(this);
    }

    /*
    解决所有版本的沉浸栏
     */
    protected void setStatusBar(Activity activity) {
        immersionBar = ImmersionBar.with(activity);
        immersionBar.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (immersionBar != null) {
            immersionBar.destroy();
        }
    }

    protected void initView() {
    }

    protected void setListern() {
    }

    protected void initData() {
    }

    /*
  数据加载的时候等待
   */
    private void initDailog() {
        builder = new LoadingDailog.Builder(this);


    }

    public void showDialog(String msg) {
        builder.setMessage(msg).setCancelable(true);
        dialog = builder.create();
        dialog.show();

    }

    public void dissMissDialog() {
        if (dialog!=null&&dialog.isShowing()){
            dialog.dismiss();
        }

    }

    public void havedeplaydissMissDialog() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 1500);
    }

    /**
     * 显示短toast
     *
     * @param msg
     */
    public void toastShort(String msg) {
        if (null == toast) {
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setText(msg);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }

    /*
 判断字符串是否为空
  */
    public boolean isEmpty(CharSequence string) {
        return TextUtils.isEmpty(string);
    }
}
