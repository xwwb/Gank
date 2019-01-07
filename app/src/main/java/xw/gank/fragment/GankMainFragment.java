package xw.gank.fragment;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.xw.gank.R;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xw.gank.adapter.MyPagerAdapter;
import xw.gank.config.Config;


public class GankMainFragment extends LazyloadFragment implements TabLayout.BaseOnTabSelectedListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.gank_main_tab_layout)
    TabLayout gankMainTabLayout;
    @BindView(R.id.gank_main_viewpager)
    ViewPager gankMainViewpager;
    private String[] titleString = {"Android", "iOS", "前端", "拓展资源"};

    Unbinder unbinder;

    @Override
    protected int setContentView() {
        return R.layout.fragment_gank_main;
    }

    @Override
    protected void init() {
        unbinder = ButterKnife.bind(this, rootView);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void lazyLoad() {
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        for (String ignored : titleString) {
            fragmentArrayList.add(new OtherGankFragment());
        }
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), fragmentArrayList, titleString);
        gankMainViewpager.setAdapter(pagerAdapter);
        gankMainViewpager.setCurrentItem(0);
        gankMainTabLayout.setupWithViewPager(gankMainViewpager);
        gankMainViewpager.setOffscreenPageLimit(fragmentArrayList.size()-1);
        gankMainTabLayout.setTabRippleColor(ColorStateList.valueOf(android.R.color.transparent));
        setListern();

    }

    private void setListern() {
        gankMainTabLayout.addOnTabSelectedListener(this);
        gankMainViewpager.addOnPageChangeListener(this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Config.GANK_TYPE=titleString[tab.getPosition()];
        Log.i("=====GankMainFragment","onTabSelected");
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        Config.GANK_TYPE=titleString[i];
        Log.i("=====GankMainFragment","onPageSelected");
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
