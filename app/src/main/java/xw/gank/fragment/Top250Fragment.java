package xw.gank.fragment;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
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
import xw.gank.activity.MoveDetailsActivity;
import xw.gank.adapter.NewMoveRecycleViewAdapter;
import xw.gank.config.Config;
import xw.gank.custom.ImageViewRoundOval;
import xw.gank.info.MoviesBean;
import xw.gank.request.RequestListern;
import xw.gank.request.Top250MoveRequest;

/**
 * A simple {@link Fragment} subclass.
 */
public class Top250Fragment extends LazyloadFragment implements RequestListern, OnRefreshListener, OnLoadMoreListener {


    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    Unbinder unbinder;
    private List<MoviesBean.SubjectsBean> data = new ArrayList<>();
    private NewMoveRecycleViewAdapter adapter;

    private Top250MoveRequest top250MoveRequest;
    @BindView(R.id.error_text)
    TextView errorText;
    @BindView(R.id.smartRefreshlayout)
    SmartRefreshLayout smartRefreshlayout;


    public Top250Fragment() {
        // Required empty public constructor
    }


    @Override
    protected int setContentView() {
        return R.layout.fragment_love;
    }

    @Override
    protected void init() {
        unbinder = ButterKnife.bind(this, rootView);
        top250MoveRequest = new Top250MoveRequest();
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
        top250MoveRequest.requestBestData(getActivity(),String.valueOf(start), this);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ImageViewRoundOval imageViewRoundOval = view.findViewById(R.id.image);
                String small = data.get(position).getImages().getSmall();
                String original_title = data.get(position).getOriginal_title();
                String alt = data.get(position).getAlt();
                Intent intent = new Intent(getActivity(), MoveDetailsActivity.class);
                intent.putExtra("alt", alt);
                intent.putExtra("name", original_title);
                intent.putExtra("imageUrl", small);
                ActivityOptions option = ActivityOptions.makeSceneTransitionAnimation(getActivity(),imageViewRoundOval,getString(R.string.sharedView));
                ActivityCompat.startActivity(Objects.requireNonNull(getActivity()),
                        intent, option.toBundle());
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void OnSucess(String string) {
        if (string != null) {

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
    public void onRefresh(RefreshLayout refreshlayout) {
        isFresh = true;
        isLoadMore = false;
        top250MoveRequest.requestBestData(getActivity(), Config.start, this);
    }


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        isFresh = false;
        start = start + 20;
        isLoadMore = true;

        Config.start = String.valueOf(start);
        top250MoveRequest.requestBestData(getActivity(), Config.start, this);
    }
}
