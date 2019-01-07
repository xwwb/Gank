package xw.gank.fragment;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xw.gank.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import xw.gank.activity.OtherGankDeatilsActivity;
import xw.gank.adapter.OtherGankRecycleViewAdapter;
import xw.gank.config.Config;
import xw.gank.info.GankModel;
import xw.gank.retrofit.ApiService;
import xw.gank.retrofit.ConstantApi;
import xw.gank.retrofit.RetrofitUtils;


public class OtherGankFragment2 extends LazyloadFragment implements BaseQuickAdapter.OnItemClickListener, OnRefreshListener, OnLoadMoreListener {


    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.smartRefreshlayout)
    SmartRefreshLayout smartRefreshlayout;
    Unbinder unbinder;
    private List<GankModel.ResultsBean> data = new ArrayList<>();
    private OtherGankRecycleViewAdapter recycleViewAdapter;
    @Override
    protected int setContentView() {
        return R.layout.fragment_other_gank;
    }

    @Override
    protected void init() {
        Log.i("====OtherGankFragment1", "init2");

        unbinder = ButterKnife.bind(this, rootView);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleView.setItemAnimator(new DefaultItemAnimator());
        recycleViewAdapter = new OtherGankRecycleViewAdapter(data, getActivity(),0);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.recycleview_empty_layout, null);
        recycleViewAdapter.setEmptyView(inflate);
        recycleView.setAdapter(recycleViewAdapter);
        recycleViewAdapter.setOnItemClickListener(this);
        smartRefreshlayout.setOnRefreshListener(this);
        smartRefreshlayout.setOnLoadMoreListener(this);
        getListData(count, pager);
    }

    @Override
    protected void lazyLoad() {
        Log.i("====OtherGankFragment2", "lazyLoad2");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        Config.GANK_TYPE = "Android";
    }

    private void getListData(int count, int page) {
        RetrofitUtils.getInstance(getActivity(), ConstantApi.Url).create(ApiService.class).getData(Config.GANK_TYPE, count, page).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GankModel grilBean) {

                        List<GankModel.ResultsBean> results = grilBean.getResults();
                        if (results.size() != 0) {
                            if (isFresh) {
                                data.clear();
                            }
                            for (int i = 0; i < results.size(); i++) {
                                List<String> images = results.get(i).getImages();
                                if (images == null) {
                                    results.get(i).setItemType(GankModel.IMG);
                                } else {
                                    results.get(i).setItemType(GankModel.TEXT);
                                }
                            }
                            Log.i("=====onNext2", "onNext");
                            data.addAll(results);
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
        Intent intent = new Intent(getActivity(), OtherGankDeatilsActivity.class);
        intent.putExtra("url", resultsBean.getUrl());
        intent.putExtra("desc", "" + resultsBean.getDesc());
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        pager = 1;
        isFresh = true;
        isLoadMore = false;
        getListData(count, pager);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        pager++;
        isLoadMore = true;
        isFresh = false;
        getListData(count, pager);
    }
    public static Fragment newInstance(String arg) {
        OtherGankFragment2 fragment = new OtherGankFragment2();
        Bundle bundle = new Bundle();
        bundle.putString("name", arg);
        fragment.setArguments(bundle);
        return fragment;
    }
}
