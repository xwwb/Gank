package xw.gank.activity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.xw.gank.R;
import com.xw.library.utils.utils.LoadingDailog;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import xw.gank.retrofit.RetrofitUtils;

public abstract class MyBaseActivity extends AppCompatActivity {

    public ImmersionBar immersionBar;
    private LoadingDailog dialog;
    private LoadingDailog.Builder builder;
    private Toast toast;
    public Context context;
    private Unbinder bind;
    int count = 20;
    int pager = 1;
    boolean isFresh;
    boolean isLoadMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
        context = this;
        boolean networkAvailable = RetrofitUtils.isNetworkAvailable(this);
        if (!networkAvailable) {
            Toast.makeText(context, getResources().getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
        setStatusBar(this);
        initView();
        initData();
        setListern();
        initDailog();
    }

    /*
        解决所有版本的沉浸栏
         */
    public void setStatusBar(Activity activity) {
        immersionBar = ImmersionBar.with(activity);
        immersionBar.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (immersionBar != null) {
            immersionBar.destroy();
        }
        bind.unbind();

    }

    public void share(String url) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share));
        intent.putExtra(Intent.EXTRA_TEXT, getShareContents(url));
        startActivity(Intent.createChooser(intent, getTitle()));
    }

    private String getShareContents(String url) {
        if (url == null) {
            url = "";
        }
        return getString(R.string.share_contents, "", url);
    }

    public void browserOpenWeb(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void copyText(String url) {
        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData mClipData = ClipData.newPlainText("Label", url);
        cm.setPrimaryClip(mClipData);
        Toast.makeText(context, getString(R.string.copy_success), Toast.LENGTH_SHORT).show();
    }

    protected abstract void initView();


    protected abstract void setListern();


    protected abstract void initData();

    public abstract int getLayoutId();

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
        if (dialog != null && dialog.isShowing()) {
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
