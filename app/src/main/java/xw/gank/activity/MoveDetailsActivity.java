package xw.gank.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xw.gank.R;
import com.xw.library.utils.activity.BaseActivity;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import xw.gank.custom.ProgressBarWebView;

public class MoveDetailsActivity extends BaseActivity {


    @BindView(R.id.progressBarWebview)
    ProgressBarWebView progressBarWebview;
    @BindView(R.id.details_image)
    ImageView detailsImage;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.CollapsingToolbarLayout)
    android.support.design.widget.CollapsingToolbarLayout CollapsingToolbarLayout;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.fab_detail)
    FloatingActionButton fabDetail;
    @BindView(R.id.view)
    View view;
    private String alt;
    //private TitleBuilder titleBuilder;
    private String name;
    private View empty_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_details);
        ButterKnife.bind(this);
        initView();
        initData();
        setListern();
    }

    @Override
    protected void initView() {
        super.initView();
      //  view.setBackgroundColor(getResources().getColor(R.color.title_layout_color));
        CollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        CollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));//设置收缩后Toolbar上字体的颜色
        initViewSetting();
        empty_layout = findViewById(R.id.empty_layout);
        immersionBar.titleBar(toolbar);
    }

    @Override
    protected void initData() {
        super.initData();
        alt = getIntent().getStringExtra("alt");
        name = getIntent().getStringExtra("name");
        String imageUrl = getIntent().getStringExtra("imageUrl");
        Glide.with(this).load(imageUrl).placeholder(R.mipmap.ic_loading).error(R.mipmap.ic_load_fail).diskCacheStrategy(DiskCacheStrategy.ALL).into(detailsImage);
        //    Utils.setPicassoImage(this, imageUrl, detailsImage, R.mipmap.plachold);
        // titleBuilder.setTitleText(name);
        toolbar.setTitle("" + name);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        initProgressWebViewData();

    }

    @Override
    protected void setListern() {
        super.setListern();
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                Log.i("======onOffsetChanged", "onOffsetChanged");
            }
        });
        fabDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initProgressWebViewData() {
        progressBarWebview.loadUrl(alt);
        progressBarWebview.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String s1, String s2, String s3, long l) {
                if (url != null && url.startsWith("http://"))
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }

        });
        progressBarWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);//在当前webview跳转新的url
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        empty_layout.setVisibility(View.GONE);
                        progressBarWebview.setVisibility(View.VISIBLE);
                    }
                }, 500);
            }
        });


    }

    private void initViewSetting() {
        WebSettings settings = progressBarWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        progressBarWebview.getSettings().setDefaultTextEncodingName("UTF -8");//设置默认为utf-8
        //支持屏幕缩放
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        //不显示webview缩放按钮
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        //settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
    }

    private void share() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share));
        intent.putExtra(Intent.EXTRA_TEXT, getShareContents());
        startActivity(Intent.createChooser(intent, getTitle()));
    }

    private String getShareContents() {
        if (alt == null) {
            alt = "";
        }
        return getString(R.string.share_contents, name, alt);
    }
}
