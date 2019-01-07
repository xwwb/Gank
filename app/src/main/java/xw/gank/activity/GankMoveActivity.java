package xw.gank.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xw.gank.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import xw.gank.adapter.OtherGankRecycleViewAdapter;
import xw.gank.info.GankModel;
import xw.gank.retrofit.ApiService;
import xw.gank.retrofit.ConstantApi;
import xw.gank.retrofit.RetrofitUtils;

public class GankMoveActivity extends MyBaseActivity implements View.OnClickListener, BaseQuickAdapter.OnItemClickListener, OnRefreshListener, OnLoadMoreListener {
    @BindView(R.id.view)
    View view;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.smartRefreshlayout)
    SmartRefreshLayout smartRefreshlayout;
    private List<GankModel.ResultsBean> data = new ArrayList<>();
    private OtherGankRecycleViewAdapter recycleViewAdapter;
    private int flags;

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
         flags = getIntent().getFlags();
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setItemAnimator(new DefaultItemAnimator());
        recycleViewAdapter = new OtherGankRecycleViewAdapter(data, this,flags);
        View inflate = LayoutInflater.from(this).inflate(R.layout.recycleview_empty_layout, null);
        recycleViewAdapter.setEmptyView(inflate);
        recycleView.setAdapter(recycleViewAdapter);
        recycleViewAdapter.setOnItemClickListener(this);
        smartRefreshlayout.setOnRefreshListener(this);
        smartRefreshlayout.setOnLoadMoreListener(this);
    }

    @Override
    protected void setListern() {
        toolbar.setNavigationOnClickListener(this);
    }

    @Override
    protected void initData() {
        getListData(flags, count, pager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getWindow().setExitTransition(new Explode());
    }

    @Override
    public int getLayoutId() {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        return R.layout.activity_gank_move;
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    private void getListData(int flags, int count, int page) {
        Observable<GankModel> data;
        if (flags == 2) {
            String type = getIntent().getStringExtra("type");
            toolbar.setTitle(type);
            data= RetrofitUtils.getInstance(this, ConstantApi.Url).create(ApiService.class).getAboutAndroid(type,"Android",count,page);
        }else{
            data = RetrofitUtils.getInstance(this, ConstantApi.Url).create(ApiService.class).getData(getResources().getString(R.string.rest_video), count, page);
        }
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GankModel grilBean) {

                        List<GankModel.ResultsBean> results = grilBean.getResults();
                        if (grilBean instanceof GankModel && results.size() != 0) {
                            if (isFresh) {
                                GankMoveActivity.this.data.clear();
                            }
                            for (int i = 0; i < results.size(); i++) {
                                List<String> images = results.get(i).getImages();
                                if (images == null) {
                                    results.get(i).setItemType(GankModel.IMG);
                                } else {
                                    results.get(i).setItemType(GankModel.TEXT);
                                }
                            }
                            Log.i("=====onNext", "onNext");
                            GankMoveActivity.this.data.addAll(results);
                            recycleViewAdapter.notifyDataSetChanged();
                            smartRefreshlayout.finishLoadMore();
                            smartRefreshlayout.finishRefresh();
                        }
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
                            return;
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.i("==========onComplete", "onComplete");
                    }
                });
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        GankModel.ResultsBean resultsBean = data.get(position);
        Intent intent = new Intent(this, OtherGankDeatilsActivity.class);
        intent.putExtra("url", resultsBean.getUrl());
        intent.putExtra("desc", "" + resultsBean.getDesc());
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        pager = 1;
        isFresh = true;
        isLoadMore = false;
        getListData(flags, count, pager);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        pager++;
        isLoadMore = true;
        isFresh = false;
        getListData(flags, count, pager);
    }
}
