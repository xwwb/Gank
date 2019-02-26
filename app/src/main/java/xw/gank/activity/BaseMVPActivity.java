package xw.gank.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import xw.gank.CallBack.IPresenter;
import xw.gank.CallBack.IView;

public abstract class BaseMVPActivity<T extends IPresenter> extends AppCompatActivity implements IView {

    protected T mPresenter;
    private Unbinder bind;
    public ImmersionBar immersionBar;
    protected Context context;
    protected  boolean isFresh=false;
    protected  boolean isLoadMore=false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
        context=this;
        setStatusBar(this);
        initPresenter();
        init();
        initData();
        setListern();
    }

    protected void initPresenter() {
        mPresenter = createPresenter();
        //绑定生命周期
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /*
          解决所有版本的沉浸栏
           */
    public void setStatusBar(Activity activity) {
        immersionBar = ImmersionBar.with(activity);
        immersionBar.init();
    }


    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        bind.unbind();
        super.onDestroy();
    }

    /**
     * 创建一个Presenter
     *
     * @return
     */
    protected abstract T createPresenter();

    protected abstract void init();

    protected abstract void setListern();


    protected abstract void initData();

    public abstract int getLayoutId();

}
