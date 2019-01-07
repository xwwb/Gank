package xw.gank.fragment;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.flyco.tablayout.SlidingTabLayout;
import com.xw.gank.R;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xw.gank.adapter.MyPagerAdapter;
import xw.gank.config.Config;

public class DouBanMainFragment extends LazyloadFragment {
    Unbinder unbinder;
    @BindView(R.id.douban_sliding_layout)
    SlidingTabLayout doubanSlidingLayout;
    @BindView(R.id.douban_viewpager)
    ViewPager doubanViewpager;
    @BindView(R.id.douban_tab_layout)
    TabLayout doubanTabLayout;
    private String[] titleString = {"热映", "预播", "Top250", "爱情", "喜剧", "动画", "科幻", "动作", "经典"};

    @Override
    protected int setContentView() {
        return R.layout.fragment_dou_ban_main;
    }

    @Override
    protected void init() {
        unbinder = ButterKnife.bind(this, rootView);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void lazyLoad() {
        Log.i("====DouBanMainFragment", "lazyLoad");
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new NewsFragment());
        fragmentArrayList.add(new PreSowingFragment());
        fragmentArrayList.add(new Top250Fragment());
        for (int i = 3; i < titleString.length; i++) {
            fragmentArrayList.add(new OtherMoiveFragment());
        }
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), fragmentArrayList, titleString);
        doubanViewpager.setAdapter(pagerAdapter);
        doubanTabLayout.setupWithViewPager(doubanViewpager);
//        doubanTabLayout.setViewPager(doubanViewpager, titleString);
        doubanViewpager.setOffscreenPageLimit(fragmentArrayList.size() - 1);
        doubanTabLayout.setTabRippleColor(ColorStateList.valueOf(android.R.color.transparent));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        doubanViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Config.MOVE_TYPE = titleString[i];
                Log.i("======onPageSelected", "" + Config.MOVE_TYPE);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
//        doubanSlidingLayout.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelect(int position) {
//                Log.i("====title", "" + titleString[position]);
//                Config.MOVE_TYPE = titleString[position];
//                Log.i("======onTabSelect", "" + titleString[position]);
//            }
//
//            @Override
//            public void onTabReselect(int position) {
//
//            }
//        });\
        doubanTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.i("====title", "" + titleString[position]);
                Config.MOVE_TYPE = titleString[position];
                Log.i("======onTabSelect", "" + titleString[position]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
