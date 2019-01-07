package xw.gank.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xw.gank.activity.MoveDetailsActivity;
import xw.gank.adapter.NewMoveRecycleViewAdapter;
import xw.gank.config.Config;
import xw.gank.info.MoviesBean;
import xw.gank.request.MoveRequest;
import xw.gank.request.RequestListern;

/**
 * A simple {@link Fragment} subclass.
 * 爱情的Fragment
 */
public class OtherMoiveFragment extends LazyloadFragment implements RequestListern, OnRefreshListener, OnLoadMoreListener {
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    Unbinder unbinder;
    @BindView(R.id.smartRefreshlayout)
    SmartRefreshLayout smartRefreshlayout;
    @BindView(R.id.error_text)
    TextView errorText;
    private List<MoviesBean.SubjectsBean> data = new ArrayList<>();
    private NewMoveRecycleViewAdapter adapter;
    private MoveRequest moveRequest;


    public OtherMoiveFragment() {
        // Required empty public constructor
    }


    @Override
    protected int setContentView() {
        return R.layout.fragment_love;
    }

    @Override
    protected void init() {
        unbinder = ButterKnife.bind(this, rootView);
        smartRefreshlayout.setOnRefreshListener(this);
        smartRefreshlayout.setOnLoadMoreListener(this);
        recycleView.setLayoutManager(new LinearLayoutManager( getActivity()));
        adapter = new NewMoveRecycleViewAdapter(getActivity(),data);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.recycleview_empty_layout, null);
        adapter.setEmptyView(inflate);
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        recycleView.setAdapter(adapter);
    }

    @Override
    protected void lazyLoad() {
        Log.i("=====start",""+start);
        Log.i("====OtherMoiveFragment","lazyLoad");
        moveRequest = new MoveRequest();
        moveRequest.requestBestData(getActivity(), Config.MOVE_TYPE, String.valueOf(start), this);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String small = data.get(position).getImages().getSmall();
                String original_title = data.get(position).getOriginal_title();
                String alt = data.get(position).getAlt();
                Intent intent = new Intent(getActivity(), MoveDetailsActivity.class);
                intent.putExtra("alt", alt);
                intent.putExtra("name", original_title);
                intent.putExtra("imageUrl",small);
                startActivity(intent);
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
        Log.i("====string", "" + string);
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
        Log.i("====error", "" + error.getMessage());
        smartRefreshlayout.setVisibility(View.GONE);
        errorText.setVisibility(View.VISIBLE);
        errorText.setText("" + error.getMessage());


    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        isFresh = true;
        isLoadMore = false;
        moveRequest.requestBestData(getActivity(), Config.StringLove, Config.start, this);
    }


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        isFresh = false;
        start = start + 20;
        isLoadMore = true;

        Config.start = String.valueOf(start);
        moveRequest.requestBestData(getActivity(), Config.StringLove, Config.start, this);
    }
}
