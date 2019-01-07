package xw.gank.activity;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Slide;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
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
import xw.gank.adapter.SearchRecycleAdapter;
import xw.gank.info.AboutAndroidBean;
import xw.gank.retrofit.ApiService;
import xw.gank.retrofit.ConstantApi;
import xw.gank.retrofit.RetrofitUtils;

public class SearchActivity2 extends MyBaseActivity implements OnRefreshListener {
    private String TAG=SearchActivity2.this.getPackageName();
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private List<AboutAndroidBean.DataBean> data = new ArrayList<>();
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.smartRefreshlayout)
    SmartRefreshLayout smartRefreshlayout;
    private SearchRecycleAdapter searchRecycleAdapter;
    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setItemAnimator(new DefaultItemAnimator());
        searchRecycleAdapter = new SearchRecycleAdapter(this, data);
        View inflate = LayoutInflater.from(this).inflate(R.layout.recycleview_empty_layout, null);
        searchRecycleAdapter.setEmptyView(inflate);
        smartRefreshlayout.setEnableLoadMore(false);
        recycleView.setAdapter(searchRecycleAdapter);
    }

    @Override
    protected void setListern() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        smartRefreshlayout.setOnRefreshListener(this);
    }

    @Override
    protected void initData() {
        getAbourAndroid();
    }

    private void getAbourAndroid() {
        RetrofitUtils.getAboutAndroidInstance(this,ConstantApi.AboutAndroidUrlBase).create(ApiService.class).getAboutAndroid()
        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AboutAndroidBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AboutAndroidBean aboutAndroidBean) {
                        if (isFresh){
                            data.clear();
                            isFresh=false;
                            smartRefreshlayout.finishRefresh(1500);
                        }
                        List<AboutAndroidBean.DataBean> allData = aboutAndroidBean.getData();
                        data.addAll(allData);
                        searchRecycleAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("====="+TAG,"==="+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public int getLayoutId() {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Slide());
        }
        return R.layout.activity_search2;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Slide());
        }
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        isFresh=true;
        getAbourAndroid();
    }
}
