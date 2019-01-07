package xw.gank.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.chrisbanes.photoview.OnOutsidePhotoTapListener;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;
import com.xw.gank.R;

import java.io.IOException;
import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import xw.gank.custom.PullBackLayout;
import xw.gank.retrofit.ApiService;
import xw.gank.retrofit.ConstantApi;
import xw.gank.retrofit.RetrofitUtils;
import xw.gank.retrofit.SystemUiVisibilityUtil;
import xw.gank.utils.ImageUtils;

public class PhotoDetailsActivity extends MyBaseActivity implements PullBackLayout.Callback, OnOutsidePhotoTapListener, OnPhotoTapListener {
    @BindView(R.id.photo_iv)
    ImageView photoIv;
    @BindView(R.id.pull_back_layout)
    PullBackLayout pullBackLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.photo_touch_iv)
    PhotoView photoTouchIv;
    @BindView(R.id.background)
    RelativeLayout background;

    private String url;
    private ColorDrawable mBackground;
    private boolean mIsToolBarHidden;
    private boolean mIsStatusBarHidden;
    private Bitmap bitmap;
    private String photoId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        //  initBackground();
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("妹纸");
        // initLazyLoadView();
    }

    @Override
    protected void setListern() {
        pullBackLayout.setCallback(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        photoTouchIv.setOnOutsidePhotoTapListener(this);
        photoTouchIv.setOnPhotoTapListener(this);

    }

    private void initLazyLoadView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getEnterTransition().addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {

                }

                @Override
                public void onTransitionEnd(Transition transition) {
                    showToolBarAndPhotoTouchView();
                }

                @Override
                public void onTransitionCancel(Transition transition) {

                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });
        } else {
            showToolBarAndPhotoTouchView();
        }
    }

    @Override
    protected void initData() {
        url = getIntent().getStringExtra("url");
        photoId = getIntent().getStringExtra("id");
        Picasso.with(this).load(url).into(photoTouchIv);
        // Glide.with(this).load(url).asBitmap().fitCenter().placeholder(R.mipmap.ic_loading).error(R.mipmap.ic_load_fail).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(photoTouchIv);
        //   Glide.with(this).load(bmp).asBitmap().fitCenter().placeholder(R.mipmap.ic_loading).error(R.mipmap.ic_load_fail).into(photoTouchIv);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_photo_details;
    }

    @Override
    public void onPullStart() {
        toolBarFadeOut();
        mIsStatusBarHidden = true;
        hideOrShowStatusBar();
    }

    @Override
    public void onPull(float progress) {
        progress = Math.min(1f, progress * 3f);
        mBackground.setAlpha((int) (0xff/*255*/ * (1f - progress)));
    }

    @Override
    public void onPullCancel() {
        toolBarFadeIn();
    }

    @Override
    public void onPullComplete() {
        supportFinishAfterTransition();
    }

    @Override
    public void supportFinishAfterTransition() {
        super.supportFinishAfterTransition();
    }

    private void showToolBarAndPhotoTouchView() {
        toolBarFadeIn();
        loadPhotoTouchIv();
    }

    private void toolBarFadeOut() {
        mIsToolBarHidden = false;
        hideOrShowToolbar();
    }

    private void toolBarFadeIn() {
        mIsToolBarHidden = true;
        hideOrShowToolbar();
    }

    private void loadPhotoTouchIv() {
        Picasso.with(this)
                .load(url)
                .error(R.mipmap.ic_load_fail)
                .into(photoTouchIv);
    }

    protected void hideOrShowToolbar() {

        toolbar.animate()
                .alpha(mIsToolBarHidden ? 1.0f : 0.0f)
                .setInterpolator(new DecelerateInterpolator(2))
                .start();
        mIsToolBarHidden = !mIsToolBarHidden;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_photo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_share:
                share(url);
                break;
            case R.id.action_save:
                getPermission();
                break;
            case R.id.action_set_wallpaper:
                ImageUtils.setWallpaper(photoId, this);
                break;
        }
        return true;
    }

    private void savePhoto() {
        RetrofitUtils.getInstance(context,ConstantApi.Url).create(ApiService.class).downloadPicFromNet(url).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {

                        Log.i("=====responseBody", "responseBody");
                        try {
                            byte[] bytes = responseBody.bytes();
                            Log.i("====byte", "" + bytes.length);
                            bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                            if (bitmap != null) {
                                ImageUtils.saveFile(bitmap, context, photoId);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    private void hideOrShowStatusBar() {
        if (mIsStatusBarHidden) {
            SystemUiVisibilityUtil.enter(PhotoDetailsActivity.this);
        } else {
            SystemUiVisibilityUtil.exit(PhotoDetailsActivity.this);
        }
        mIsStatusBarHidden = !mIsStatusBarHidden;
    }

//    private void initBackground() {
//        mBackground = new ColorDrawable(Color.BLACK);
//        View childAt = ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
//        childAt.setBackgroundDrawable(mBackground);
//    }

    @OnClick(R.id.photo_touch_iv)
    public void onViewClicked() {
//        hideOrShowToolbar();
//        hideOrShowStatusBar();
    }

    @Override
    public void onOutsidePhotoTap(ImageView imageView) {
        hideOrShowToolbar();
        hideOrShowStatusBar();
    }

    @Override
    public void onPhotoTap(ImageView view, float x, float y) {
        hideOrShowToolbar();
        hideOrShowStatusBar();
    }



    private void getPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // 没有获得授权，申请授权
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this, android.Manifest.permission.CAMERA)) {
                Toast.makeText(this, "请授权！", Toast.LENGTH_LONG).show();
                // 帮跳转到该应用的设置界面，让用户手动授权
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri1 = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri1);
                startActivity(intent);
            } else {
                // 不需要解释为何需要该权限，直接请求授权
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        } else {
            savePhoto();

        }
    }
}
