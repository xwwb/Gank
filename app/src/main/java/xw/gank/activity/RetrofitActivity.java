package xw.gank.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.clans.fab.FloatingActionButton;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xw.gank.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import xw.gank.adapter.RetorfitRecycleViewAdapter;
import xw.gank.CallBack.IntentServiceCallBack;
import xw.gank.info.GankModel;
import xw.gank.info.GirlItemData;
import xw.gank.retrofit.ApiService;
import xw.gank.retrofit.ConstantApi;
import xw.gank.retrofit.RetrofitUtils;
import xw.gank.service.DataService;
import xw.gank.utils.CallBackUtils;


public class RetrofitActivity extends MyBaseActivity implements OnLoadMoreListener, OnRefreshListener, BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.OnItemClickListener, IntentServiceCallBack {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.smartRefreshlayout)
    SmartRefreshLayout smartRefreshlayout;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private List<GirlItemData> data = new ArrayList<>();
    private RetorfitRecycleViewAdapter adapter;
    private Activity activity;

    @Override
    protected void initView() {
        activity = this;
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        CallBackUtils.setIntentServiceCallBack(this);
        adapter = new RetorfitRecycleViewAdapter(this, data);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        recycleView.setLayoutManager(staggeredGridLayoutManager);
        recycleView.setItemAnimator(new DefaultItemAnimator());
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        @SuppressLint("InflateParams") View inflate = LayoutInflater.from(this).inflate(R.layout.recycleview_empty_layout, null);
        adapter.setEmptyView(inflate);
        recycleView.setAdapter(adapter);
        fab.hide(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fab.show(true);
                fab.setShowAnimation(AnimationUtils.loadAnimation(RetrofitActivity.this, R.anim.show_from_bottom));
                fab.setHideAnimation(AnimationUtils.loadAnimation(RetrofitActivity.this, R.anim.hide_to_bottom));
            }
        }, 500);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
        }

        // getWindow().setExitTransition(new Slide());
        // getWindow().setExitTransition(new Fade());
    }


    @Override
    protected void setListern() {
        smartRefreshlayout.setOnRefreshListener(this);
        smartRefreshlayout.setOnLoadMoreListener(this);
        recycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                StaggeredGridLayoutManager layoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                if (layoutManager != null) {
                    layoutManager.invalidateSpanAssignments();
                }
                if (isFinishing()) {
                    return;
                }
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    fab.show(true);
                } else if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    fab.hide(true);
                }
                Log.i("====newState", "" + newState);
                Log.i("===onScrollStateChanged", "onScrollStateChanged");
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });

        adapter.setOnItemClickListener(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recycleView.smoothScrollToPosition(0);
            }
        });


    }

    @Override
    protected void initData() {
        getListData(count, pager);
    }

    private void getListData(int count, int page) {
        RetrofitUtils.getInstance(this, ConstantApi.Url).create(ApiService.class).getData("福利", count, page).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GankModel grilBean) {
                        if (isFresh) {
                            data.clear();
                            smartRefreshlayout.finishRefresh();
                        }

                        List<GankModel.ResultsBean> results = grilBean.getResults();
                        List<GirlItemData> datas = new ArrayList<>();
                        for (int i = 0; i < results.size(); i++) {
                            GirlItemData girlItemData = new GirlItemData();
                            girlItemData.setUrl(results.get(i).getUrl());
                            girlItemData.setId(results.get(i).get_id());
                            GankModel.ResultsBean resultsBean = results.get(i);
                            String desc = resultsBean.getDesc();
                            Log.i("======desc", "" + desc + "---" + resultsBean.getWho());
                            datas.add(girlItemData);
                        }
                        DataService.startService(context, datas, "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("====onError", e.getMessage());
                        if (isFresh) {
                            smartRefreshlayout.finishRefresh();
                            return;
                        }
                        if (isLoadMore) {
                            smartRefreshlayout.finishLoadMore();
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.i("==========onComplete", "onComplete");
                    }
                });
    }

    @Override
    public int getLayoutId() {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Explode());
        }
        //  getWindow().setEnterTransition(new Slide());
        //   getWindow().setEnterTransition(new Fade());
        return R.layout.activity_retrofit;
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        pager++;
        isLoadMore = true;
        isFresh = false;
        getListData(count, pager);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        pager = 1;
        isFresh = true;
        isLoadMore = false;
        getListData(count, pager);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {


    }

    private void startIntent(View view, Intent intent, Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions
                    .makeSceneTransitionAnimation(activity, view, getString(R.string.image));
            startActivity(intent, options.toBundle());
        } else {
            ActivityOptionsCompat options = ActivityOptionsCompat
                    .makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
            ActivityCompat.startActivity(activity, intent, options.toBundle());
        }

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, final View view, int position) {
        String url = data.get(position).getUrl();
        String id = data.get(position).getId();
        Intent intent = new Intent(this, PhotoDetailsActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("url", url);
        startIntent(view, intent, activity);
    }

    @Override
    public void intentServiceCallBack(final List<GirlItemData> datas) {
        Log.i("=====dataSize", "" + datas.size());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (isFinishing()) {
                    return;
                }
                if (isLoadMore) {
                    smartRefreshlayout.finishLoadMore();
                }
                data.addAll(datas);
                adapter.notifyDataSetChanged();

            }
        });

    }

    @Override
    public void intentServiceCallBack(String string) {

    }

    /**
     * 全透状态栏
     */
    protected void setStatusBarFullTransparent() {

        if (Build.VERSION.SDK_INT >= 21) {//21表示5.0
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= 19) {//19表示4.4
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //虚拟键盘也透明
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
