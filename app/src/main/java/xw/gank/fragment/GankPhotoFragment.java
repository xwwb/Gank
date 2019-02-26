package xw.gank.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import xw.gank.activity.PhotoDetailsActivity;
import xw.gank.adapter.RetorfitRecycleViewAdapter;
import xw.gank.CallBack.IntentServiceCallBack;
import xw.gank.info.GankModel;
import xw.gank.info.GirlItemData;
import xw.gank.retrofit.ApiService;
import xw.gank.retrofit.ConstantApi;
import xw.gank.retrofit.RetrofitUtils;
import xw.gank.service.DataService;
import xw.gank.utils.CallBackUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankPhotoFragment extends LazyloadFragment implements IntentServiceCallBack, BaseQuickAdapter.OnItemClickListener, OnRefreshListener, OnLoadMoreListener {

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.smartRefreshlayout)
    SmartRefreshLayout smartRefreshlayout;
    @BindView(R.id.walfare_photo_fab)
    FloatingActionButton walfarePhotoFab;
    Unbinder unbinder;
    private List<GirlItemData> data = new ArrayList<>();
    private RetorfitRecycleViewAdapter adapter;
    private boolean isFresh;
    private int count = 20;
    private int pager = 1;
    private boolean isLoadMore;
    private Activity activity;

    public GankPhotoFragment() {
        // Required empty public constructor
    }


    @Override
    protected int setContentView() {
//        getActivity().getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
//        getActivity(). getWindow().setEnterTransition(new Explode());
        return R.layout.fragment_wal_fare_photo;
    }

    @Override
    protected void init() {
        Log.i("======init","init");
        activity = getActivity();
        unbinder = ButterKnife.bind(this, rootView);
        CallBackUtils.setIntentServiceCallBack(this);
        adapter = new RetorfitRecycleViewAdapter(getActivity(), data);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        recycleView.setLayoutManager(staggeredGridLayoutManager);
        recycleView.setItemAnimator(new DefaultItemAnimator());
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        @SuppressLint("InflateParams") View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.recycleview_empty_layout, null);
        adapter.setEmptyView(inflate);
        recycleView.setAdapter(adapter);
        walfarePhotoFab.hide(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                walfarePhotoFab.show(true);
                walfarePhotoFab.setShowAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.show_from_bottom));
                walfarePhotoFab.setHideAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.hide_to_bottom));
            }
        }, 500);
        setListern();

    }

    @Override
    protected void lazyLoad() {
        getListData(count, pager);
    }

    public void setListern() {
        smartRefreshlayout.setOnRefreshListener(this);
        smartRefreshlayout.setOnLoadMoreListener(this);
        recycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                StaggeredGridLayoutManager layoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                assert layoutManager != null;
                layoutManager.invalidateSpanAssignments();
                if (Objects.requireNonNull(getActivity()).isFinishing()){
                    return;
                }
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {

                    walfarePhotoFab.show(true);
                } else if (RecyclerView.SCROLL_STATE_DRAGGING == newState) {
                    walfarePhotoFab.hide(true);
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
        walfarePhotoFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recycleView.smoothScrollToPosition(0);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
        Intent intent = new Intent(getActivity(), PhotoDetailsActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("url", url);
        startIntent(view, intent, activity);
    }

    @Override
    public void intentServiceCallBack(final List<GirlItemData> datas) {
        Log.i("=====dataSize", "" + datas.size());
        Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (getActivity().isFinishing()){
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

    private void getListData(int count, int page) {
        RetrofitUtils.getInstance(getActivity(), ConstantApi.Url).create(ApiService.class).getData("福利", count, page).
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
                        DataService.startService(getActivity(), datas, "");
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

}
