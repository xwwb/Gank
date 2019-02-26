package xw.gank.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.xw.gank.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import xw.gank.CallBack.BasePresenterICallBack;
import xw.gank.Presenter.FirstVideoPresenter;
import xw.gank.adapter.FirstVideoRecycleViewAdapter;
import xw.gank.info.FirstVideoBean;
import xw.gank.utils.DataUtil;
import xw.gank.utils.ScrollCalculatorHelper;

public class FirstVideoActivity extends BaseMVPActivity<FirstVideoPresenter> implements BasePresenterICallBack, OnRefreshListener, OnLoadMoreListener {
    List<FirstVideoBean.DataBean> dataAll = new ArrayList<>();
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.smartRefreshlayout)
    SmartRefreshLayout smartRefreshlayout;
    private FirstVideoRecycleViewAdapter adapter;
    private LinearLayoutManager layoutManager;
    private ScrollCalculatorHelper scrollCalculatorHelper;
    boolean mFull = false;
    int page=1;
    @Override
    protected FirstVideoPresenter createPresenter() {
        return new FirstVideoPresenter();
    }

    @Override
    protected void init() {

        immersionBar.titleBar(toolbar);
        layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);

        //限定范围为屏幕一半的上下偏移180
        int playTop = CommonUtil.getScreenHeight(this) / 2 - CommonUtil.dip2px(this, 180);
        int playBottom = CommonUtil.getScreenHeight(this) / 2 + CommonUtil.dip2px(this, 180);
        //自定播放帮助类
        scrollCalculatorHelper = new ScrollCalculatorHelper(R.id.ijk_player, playTop, playBottom);
        recycleView.setItemAnimator(new DefaultItemAnimator());
         adapter = new FirstVideoRecycleViewAdapter(this,dataAll);
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        View inflate = LayoutInflater.from(this).inflate(R.layout.recycleview_empty_layout, null);
        adapter.setEmptyView(inflate);
        //VideoRecyclerViewAdapter viewAdapter = new VideoRecyclerViewAdapter(DataUtil.getVideoList(), this);
        recycleView.setAdapter(adapter);
    }

    @Override
    protected void setListern() {
     adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
         @Override
         public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
             Intent intent = new Intent(context, IjkPlayerActivity.class);
             String videoUrl = DataUtil.getVideoList().get(position).getUrl();
             intent.putExtra("title",DataUtil.getVideoList().get(position).getTitle());
             intent.putExtra("videoUrl",videoUrl);
             startActivity(intent);
         }
     });
//        recycleView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
//            @Override
//            public void onChildViewAttachedToWindow(View view) {
//
//            }
//
//            @Override
//            public void onChildViewDetachedFromWindow(View view) {
//                 ijkVideoView = view.findViewById(R.id.video_player);
//                if (ijkVideoView != null && !ijkVideoView.isFullScreen()) {
////                    Log.d("@@@@@@", "onChildViewDetachedFromWindow: called");
////                    int tag = (int) ijkVideoView.getTag();
////                    Log.d("@@@@@@", "onChildViewDetachedFromWindow: position: " + tag);
//                    ijkVideoView.stopPlayback();
//                }
//            }
//        });

        recycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            int firstVisibleItem, lastVisibleItem, visibleCount;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                scrollCalculatorHelper.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();

                //这是滑动自动播放的代码
                if (!mFull) {
                    scrollCalculatorHelper.onScroll(recyclerView, firstVisibleItem, lastVisibleItem, lastVisibleItem - firstVisibleItem);
                }
            }

//            private void autoPlayVideo(RecyclerView view) {
//                //循环遍历可视区域videoview,如果完全可见就开始播放
//                for (int i = 0; i < visibleCount; i++) {
//                    if (view == null || view.getChildAt(i) == null) continue;
//                    IjkVideoView ijkVideoView = view.getChildAt(i).findViewById(R.id.video_player);
//                    if (ijkVideoView != null) {
//                        Rect rect = new Rect();
//                        ijkVideoView.getLocalVisibleRect(rect);
//                        int videoHeight = ijkVideoView.getHeight();
//                        if (rect.top == 0 && rect.bottom == videoHeight) {
//                            ijkVideoView.start();
//                            return;
//                        }
//                    }
//                }
//            }
        });
        smartRefreshlayout.setOnRefreshListener(this);
        smartRefreshlayout.setOnLoadMoreListener(this);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (newConfig.orientation != ActivityInfo.SCREEN_ORIENTATION_USER) {
            mFull = false;
        } else {
            mFull = true;
        }

    }
    @Override
    protected void initData() {
        mPresenter.getData(this, "1", String.valueOf(page));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_first;
    }

    @Override
    public void showArticleSuccess(Object result) {
        FirstVideoBean firstVideoBean = (FirstVideoBean) result;
        List<FirstVideoBean.DataBean> data = firstVideoBean.getData();
        if (isFresh){
            isFresh=false;
            dataAll.clear();
            smartRefreshlayout.finishRefresh();
        }
        if (isLoadMore){
          isLoadMore=false;
          smartRefreshlayout.finishLoadMore();
        }

        dataAll.addAll(data);

       adapter.notifyDataSetChanged();


//        View view = recycleView.getChildAt(0);
//        IjkVideoView ijkVideoView = view.findViewById(R.id.video_player);
//        ijkVideoView.start();
    }

    @Override
    public void showArticleFail(String errorMsg) {
        Log.i("====showArticleFail", errorMsg);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //VideoViewManager.instance().releaseVideoPlayer();
        GSYVideoManager.onPause();
    }

    @Override
    public void onBackPressed() {
        if (GSYVideoManager.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
//        if (!VideoViewManager.instance().onBackPressed()){
//            super.onBackPressed();
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        GSYVideoManager.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoManager.releaseAllVideos();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        isFresh=true;
        page=1;
        mPresenter.getData(this, "1", String.valueOf(page));
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        isLoadMore=true;
        page++;
        mPresenter.getData(this, "1", String.valueOf(page));
    }
}
