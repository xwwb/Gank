package xw.gank.fragment;


import android.app.ActivityOptions;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xw.gank.R;
import com.xw.library.utils.utils.BannerViewUtils;
import com.youth.banner.Banner;

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
import xw.gank.activity.MoveDetailsActivity;
import xw.gank.adapter.NewMoveRecycleViewAdapter;
import xw.gank.config.Config;
import xw.gank.custom.ImageViewRoundOval;
import xw.gank.info.MoviesBean;
import xw.gank.request.NewsMoveRequest;
import xw.gank.request.RequestListern;
import xw.gank.retrofit.ApiService;
import xw.gank.retrofit.ConstantApi;
import xw.gank.retrofit.RetrofitUtils;

/**
 * A simple {@link Fragment} subclass.
 * 最新热映
 */
public class NewsFragment extends LazyloadFragment implements RequestListern, OnRefreshListener, OnLoadMoreListener {


    Unbinder unbinder;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.smartRefreshlayout)
    SmartRefreshLayout smartRefreshlayout;
    @BindView(R.id.error_text)
    TextView errorText;
    Unbinder unbinder1;
    private List<MoviesBean.SubjectsBean> data = new ArrayList<>();
    private NewMoveRecycleViewAdapter adapter;
    private Banner banner;
    private List<String> bannerData;
    private List<String> titleData;


    public NewsFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_love, container, false);
//        unbinder = ButterKnife.bind(this, view);
//        return view;
//    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_love;
    }

    @Override
    protected void init() {
        unbinder = ButterKnife.bind(this, rootView);
        smartRefreshlayout.setOnRefreshListener(this);
        smartRefreshlayout.setOnLoadMoreListener(this);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NewMoveRecycleViewAdapter(getActivity(), data);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.recycleview_empty_layout, null);
        adapter.setEmptyView(inflate);
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        recycleView.setAdapter(adapter);


    }

    @Override
    protected void lazyLoad() {
        // newsMoveRfequest.requestBestData(getActivity(), Config.start, this);
        getNewsMoveData();
        bannerData = new ArrayList<>();
        titleData = new ArrayList<>();
        View banner_inflate = LayoutInflater.from(getActivity()).inflate(R.layout.header_layout, null);
        banner = banner_inflate.findViewById(R.id.banner);
      //  adapter.addHeaderView(banner_inflate);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
             //   Toast.makeText(getActivity(), "gg", Toast.LENGTH_SHORT).show();
                ImageViewRoundOval imageViewRoundOval = view.findViewById(R.id.image);
                String small = data.get(position).getImages().getSmall();
                String original_title = data.get(position).getOriginal_title();
                String alt = data.get(position).getAlt();
                Intent intent = new Intent(getActivity(), MoveDetailsActivity.class);
                intent.putExtra("alt", alt);
                intent.putExtra("name", original_title);
                intent.putExtra("imageUrl", small);
                ActivityOptions option = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    option = ActivityOptions.makeSceneTransitionAnimation(getActivity(), imageViewRoundOval, getString(R.string.sharedView));
                }
                ActivityCompat.startActivity(Objects.requireNonNull(getActivity()),
                        intent, option.toBundle());
                //  startActivity(intent, option.toBundle());
                // startActivity(intent);
            }
        });


    }

    private void getNewsMoveData() {
        RetrofitUtils.getDouBanMoiveInstance(getActivity(), ConstantApi.UrlBase).create(ApiService.class).getNewNewsMoveData(Config.start)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MoviesBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MoviesBean moviesBean) {
                        Log.i("====moviesBean", "" + moviesBean.getTitle());
                        List<MoviesBean.SubjectsBean> subjects = moviesBean.getSubjects();
                        if (isFresh) {
                            data.clear();
                            smartRefreshlayout.finishRefresh(1500);
                        }
                        if (isLoadMore) {
                            smartRefreshlayout.finishLoadMore(1500);
                            if (subjects.size() == 0) {
                                smartRefreshlayout.finishLoadMoreWithNoMoreData();
                            }
                        }
                        Log.i("====subjects", "" + subjects.size());
                        data.addAll(subjects);
                        for (int i = 0; i < 5; i++) {
                            MoviesBean.SubjectsBean subjectsBean = data.get(i);
                            String small = subjectsBean.getImages().getLarge();
                            bannerData.add(small);
                            titleData.add(subjectsBean.getTitle());
                        }
                        //BannerViewUtils.setBanner(banner, bannerData, titleData, 0);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        newsMoveRfequest = new NewsMoveRequest();
//        smartRefreshlayout.setOnRefreshListener(this);
//        smartRefreshlayout.setOnLoadMoreListener(this);
//
//        newsMoveRfequest.requestBestData(getActivity(),  Config.start, this);
//        recycleView.setLayoutManager(new LinearLayoutManager( getActivity()));
//        com.xw.gank.adapter = new NewMoveRecycleViewAdapter(getActivity(),data);
//        com.xw.gank.adapter.openLoadAnimation(2);
//        recycleView.setAdapter(com.xw.gank.adapter);
//        com.xw.gank.adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter com.xw.gank.adapter, View view, int position) {
//                String small = data.get(position).getImages().getSmall();
//                String original_title = data.get(position).getOriginal_title();
//                String alt = data.get(position).getAlt();
//                Intent intent = new Intent(getActivity(), MoveDetailsActivity.class);
//                intent.putExtra("alt", alt);
//                intent.putExtra("name", original_title);
//                intent.putExtra("imageUrl",small);
//                startActivity(intent);
//            }
//        });
//        com.xw.gank.adapter.setOnItemClickListern(new MoveRecycleViewAdapter.OnItemClickListern() {
//            @Override
//            public void OnClickListern(int position) {
//                String small = data.get(position).getImages().getSmall();
//                String original_title = data.get(position).getOriginal_title();
//                String alt = data.get(position).getAlt();
//                Intent intent = new Intent(getActivity(), MoveDetailsActivity.class);
//                intent.putExtra("alt", alt);
//                intent.putExtra("name", original_title);
//                intent.putExtra("imageUrl",small);
//                startActivity(intent);
//            }
//        });

    // }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void OnSucess(String string) {
        if (string != null) {
            Log.i("=====sTRING", string);
            MoviesBean moviesBean = new Gson().fromJson(string, MoviesBean.class);
            if (moviesBean != null) {
                List<MoviesBean.SubjectsBean> subjects = moviesBean.getSubjects();
                if (isFresh) {
                    data.clear();
                    smartRefreshlayout.finishRefresh(1500);
                }
                if (isLoadMore) {
                    smartRefreshlayout.finishLoadMore(1500);
                    if (subjects.size() == 0) {
                        smartRefreshlayout.finishLoadMoreWithNoMoreData();
                    }
                }
                Log.i("====subjects", "" + subjects.size());
                data.addAll(subjects);
                for (int i = 0; i < 5; i++) {
                    MoviesBean.SubjectsBean subjectsBean = data.get(i);
                    String small = subjectsBean.getImages().getLarge();
                    bannerData.add(small);
                    titleData.add(subjectsBean.getTitle());
                }
                BannerViewUtils.setBanner(banner, bannerData, titleData, 0);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void OnError(Exception error) {
        smartRefreshlayout.setVisibility(View.GONE);
        errorText.setVisibility(View.VISIBLE);
        errorText.setText("" + error.getMessage());

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshlayout) {
        bannerData.clear();
        isFresh = true;
        isLoadMore = false;
        Config.start = "0";
        getNewsMoveData();
        //  newsMoveRfequest.requestBestData(getActivity(), Config.start, this);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        isFresh = false;
        start = start + 20;
        isLoadMore = true;
        Config.start = String.valueOf(start);
        getNewsMoveData();
        // newsMoveRfequest.requestBestData(getActivity(), Config.start, this);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // TODO: inflate a fragment view
//        View rootView = super.onCreateView(inflater, container, savedInstanceState);
//        unbinder1 = ButterKnife.bind(this, rootView);
//        return rootView;
//    }
}
