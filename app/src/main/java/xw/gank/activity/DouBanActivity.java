package xw.gank.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.xw.gank.R;
import com.xw.library.utils.activity.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xw.gank.adapter.MyPagerAdapter;
import xw.gank.fragment.NewsFragment;
import xw.gank.fragment.PreSowingFragment;
import xw.gank.fragment.Top250Fragment;
import xw.gank.utils.TitleBuilder;

public class DouBanActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.sliding_layout)
    SlidingTabLayout slidingLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.nav_view)
    NavigationView navView;

    private String[] titleString = {"热映", "预播", "Top250", "爱情", "喜剧", "动画", "科幻", "动作", "经典"};
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private TitleBuilder titleBuilder;
    private List<String> leftTitleData;
    private String[] leftTitle = {"妹子"};

    public DouBanActivity() {
        leftTitleData = new ArrayList<>();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_douban);
        ButterKnife.bind(this);
        initView();
        initData();
        setListern();
    }

    @Override
    protected void initView() {
        super.initView();
        titleBuilder = new TitleBuilder(this);
        titleBuilder.setTitleText("电影");
        titleBuilder.setRightIco(R.mipmap.search_image);
        titleBuilder.setRightIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DouBanActivity.this, SearchActivity.class);
                startActivity(intent);

            }
        });
        titleBuilder.setStatusBarBackground(getResources().getColor(R.color.title_layout_color));
        // titleBuilder.setTitleTextColor(getResources().getColor(R.color.title_layout_color));
        titleBuilder.setTitleColor(getResources().getColor(R.color.title_layout_color));


    }

    @Override
    protected void initData() {
        super.initData();
        fragmentArrayList.add(new NewsFragment());
        fragmentArrayList.add(new PreSowingFragment());
        fragmentArrayList.add(new Top250Fragment());
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentArrayList, titleString);
        viewpager.setAdapter(pagerAdapter);
        //viewpager.setOffscreenPageLimit(2);
        slidingLayout.setViewPager(viewpager, titleString);
        leftTitleData.addAll(Arrays.asList(leftTitle));

    }

    @Override
    protected void setListern() {
        super.setListern();
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                titleBuilder.setTitleText(titleString[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        slidingLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        navView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        Intent intent = new Intent();
        switch (itemId){
            case R.id.nav_photo:
                intent.setClass(this, RetrofitActivity.class);
                //      startActivity(intent);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
              drawerlayout.closeDrawer(GravityCompat.START);
                break;
        }
        return true;
    }
}
