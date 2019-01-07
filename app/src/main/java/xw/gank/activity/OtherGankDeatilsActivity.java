package xw.gank.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xw.gank.R;

import java.util.Objects;

import butterknife.BindView;
import xw.gank.custom.ProgressBarWebView;

public class OtherGankDeatilsActivity extends MyBaseActivity {

    @BindView(R.id.view)
    View view;
    @BindView(R.id.other_gank_details_toobar)
    Toolbar otherGankDetailsToobar;
    @BindView(R.id.other_gank_details_toobar_webview)
    ProgressBarWebView otherGankDetailsToobarWebview;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.empty_layout)
    RelativeLayout emptyLayout;
    private String url;

    @Override
    protected void initView() {
        setSupportActionBar(otherGankDetailsToobar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        otherGankDetailsToobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        initViewSetting();

    }

    @Override
    protected void setListern() {

    }

    @Override
    protected void initData() {
        url = getIntent().getStringExtra("url");
        String desc = getIntent().getStringExtra("desc");
        getSupportActionBar().setTitle(null);
        toolbarTitle.setText(String.format("%s", desc));
        initProgressWebViewData();
    }

    @Override
    public int getLayoutId() {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        return R.layout.activity_other_gank;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_share:
                share(url);
                break;
            case R.id.action_copy_url:
             copyText(url);
                break;
            case R.id.action_browser_open:
             browserOpenWeb(url);
                break;
            case R.id.action_refresh:
                initProgressWebViewData();
                break;
        }
        return true;
    }
    @SuppressLint("SetJavaScriptEnabled")
    private void initProgressWebViewData() {
        otherGankDetailsToobarWebview.loadUrl(url);
        otherGankDetailsToobarWebview.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String s1, String s2, String s3, long l) {
                if (url != null && url.startsWith("http://"))
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }

        });
        otherGankDetailsToobarWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);//在当前webview跳转新的url
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (!isFinishing()){
                    emptyLayout.setVisibility(View.GONE);
                    otherGankDetailsToobarWebview.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initViewSetting() {
        WebSettings settings = otherGankDetailsToobarWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        otherGankDetailsToobarWebview.getSettings().setDefaultTextEncodingName("UTF -8");//设置默认为utf-8
        //支持屏幕缩放
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        //不显示webview缩放按钮
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        //settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getWindow().setExitTransition(new Explode());
    }

}
