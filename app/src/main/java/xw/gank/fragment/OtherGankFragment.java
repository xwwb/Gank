package xw.gank.fragment;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xw.gank.R;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;

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
import xw.gank.info.AndroidBannerBean;
import xw.gank.info.GankModel;
import xw.gank.retrofit.ApiService;
import xw.gank.retrofit.ConstantApi;
import xw.gank.retrofit.RetrofitUtils;
import xw.gank.utils.BannerViewUtils;
import xw.gank.utils.ImageLoader;

/**
 *
 */
public class OtherGankFragment extends LazyloadFragment implements BaseQuickAdapter.OnItemClickListener, OnRefreshListener, OnLoadMoreListener, OnBannerClickListener, View.OnClickListener {


    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.smartRefreshlayout)
    SmartRefreshLayout smartRefreshlayout;
    Unbinder unbinder;
    private List<GankModel.ResultsBean> data = new ArrayList<>();
    private OtherGankRecycleViewAdapter recycleViewAdapter;
    private List<String> bannerImage;
    private List<String> bannerDesc;
    private Banner banner;
    private ImageView banner_image, banner_images;
    private View banner_inflate;
    private List<AndroidBannerBean.DataBean> bannerData;

    @Override
    protected int setContentView() {
        return R.layout.fragment_other_gank;
    }

    @Override
    protected void init() {
        unbinder = ButterKnife.bind(this, rootView);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleView.setItemAnimator(new DefaultItemAnimator());
        recycleViewAdapter = new OtherGankRecycleViewAdapter(data, getActivity(), 0);
        banner_inflate = LayoutInflater.from(getActivity()).inflate(R.layout.header_layout, null);
        banner = banner_inflate.findViewById(R.id.banner);
        banner_image = banner_inflate.findViewById(R.id.banner_image);
        banner_images = banner_inflate.findViewById(R.id.banner_images);
        if (Config.GANK_TYPE.equals("Android")) {
            recycleViewAdapter.addHeaderView(banner_inflate);
        } else {
            recycleViewAdapter.removeHeaderView(banner_inflate);
        }
        View empty_view = LayoutInflater.from(getActivity()).inflate(R.layout.recycleview_empty_layout, null);
        recycleViewAdapter.setEmptyView(empty_view);
        recycleView.setAdapter(recycleViewAdapter);
        recycleViewAdapter.setOnItemClickListener(this);
        smartRefreshlayout.setOnRefreshListener(this);
        smartRefreshlayout.setOnLoadMoreListener(this);
        if (banner!=null&&banner_image!=null&&banner_images!=null){
            banner.setOnBannerClickListener(this);
            banner_image.setOnClickListener(this);
            banner_images.setOnClickListener(this);
        }
    }

    @Override
    protected void lazyLoad() {
        Log.i("====OtherGankFragment", "lazyLoad");
        if (Config.GANK_TYPE.equals(getString(R.string.android))) {
            getBannerData();
        }
        if (!Config.GANK_TYPE.equals("Android")) {
            recycleViewAdapter.removeHeaderView(banner_inflate);
        }
        getListData(count, pager);
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
                                smartRefreshlayout.finishRefresh();
                            }
                            if (isLoadMore){
                                smartRefreshlayout.finishLoadMore();
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
                            data.addAll(results);
                            recycleViewAdapter.notifyDataSetChanged();

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

    private void getBannerData() {
        RetrofitUtils.getAboutAndroidInstance(getActivity(), ConstantApi.AboutAndroidUrlBase).create(ApiService.class).getAndroidBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AndroidBannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AndroidBannerBean androidBannerBean) {
                        bannerImage = new ArrayList<>();
                        bannerDesc = new ArrayList<>();
                        bannerData = androidBannerBean.getData();
                        if (bannerData.size() != 0) {
                            for (int i = 0; i < bannerData.size(); i++) {
                                AndroidBannerBean.DataBean dataBean = bannerData.get(i);
                                String imagePath = dataBean.getImagePath();
                                String desc = dataBean.getTitle();
                                if (imagePath != null && desc != null) {
                                    bannerImage.add(imagePath);
                                    bannerDesc.add(desc);
                                }
                            }
                        }
                        ImageLoader.load(getActivity(), bannerImage.get(1), banner_image);
                        ImageLoader.load(getActivity(), bannerImage.get(bannerData.size() - 1), banner_images);
                        BannerViewUtils.setBanner(banner, bannerImage, bannerDesc, 0);
                        recycleViewAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        GankModel.ResultsBean resultsBean = data.get(position);
        Intent intent = new Intent(getActivity(), OtherGankDeatilsActivity.class);
        intent.putExtra("url", resultsBean.getUrl());
        intent.putExtra("desc", "" + resultsBean.getDesc());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
        }
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        pager = 1;
        isFresh = true;
        isLoadMore = false;
        if (Config.GANK_TYPE.equals(getString(R.string.android))) {
            getBannerData();
        }
        getListData(count, pager);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        pager++;
        isLoadMore = true;
        isFresh = false;
        getListData(count, pager);
    }

    @Override
    public void OnBannerClick(int position) {
        Intent intent = new Intent(getActivity(), OtherGankDeatilsActivity.class);
        intent.putExtra("url", bannerData.get(position).getUrl());
        intent.putExtra("desc", "" + bannerDesc.get(position));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), OtherGankDeatilsActivity.class);


        switch (v.getId()){
            case R.id.banner_image:
                intent.putExtra("url", bannerData.get(1).getUrl());
                intent.putExtra("desc", "" + bannerDesc.get(1));
                break;
            case R.id.banner_images:
                intent.putExtra("url", bannerData.get(bannerData.size()-1).getUrl());
                intent.putExtra("desc", "" + bannerDesc.get(bannerData.size() - 1));
                break;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
        }
    }
}
