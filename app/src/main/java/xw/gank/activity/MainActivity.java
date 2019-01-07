package xw.gank.activity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.SwitchCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.xw.gank.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import xw.gank.adapter.MyPagerAdapter;
import xw.gank.fragment.DouBanMainFragment;
import xw.gank.fragment.GankMainFragment;
import xw.gank.fragment.GankPhotoFragment;

public class MainActivity extends MyBaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.open_drawerlayout)
    ImageView openDrawerlayout;
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.main_tablayout)
    TabLayout mainTablayout;
    @BindView(R.id.main_viewpager)
    ViewPager mainViewpager;
    @BindView(R.id.main_nav_view)
    NavigationView mainNavView;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    private String[] titleString = {"干货", "福利", "豆瓣"};
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private int flag = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        MenuItem menuNightMode = mainNavView.getMenu().findItem(R.id.nav_night_mode);
        SwitchCompat dayNightSwitch = (SwitchCompat) MenuItemCompat
                .getActionView(menuNightMode);
        dayNightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

//                getDelegate().setLocalNightMode(currentNightMode == Configuration.UI_MODE_NIGHT_NO ?
//                        AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
//                // 同样需要调用recreate方法使之生效
//                recreate();
//                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                recreate();
//                Toast.makeText(context, ""+isChecked, Toast.LENGTH_SHORT).show();
                if (isChecked) {
                   // SkinCompatManager.getInstance().loadSkin("night", null, SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
                } else {
                   // SkinCompatManager.getInstance().restoreDefaultTheme();
                }
            }
        });
    }

    @Override
    protected void setListern() {
        mainNavView.setNavigationItemSelectedListener(this);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void initData() {
        fragmentArrayList.add(new GankMainFragment());
        fragmentArrayList.add(new GankPhotoFragment());
        fragmentArrayList.add(new DouBanMainFragment());
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentArrayList, titleString);
        mainViewpager.setAdapter(pagerAdapter);
        mainTablayout.setupWithViewPager(mainViewpager);
        mainViewpager.setOffscreenPageLimit(fragmentArrayList.size() - 1);
        mainTablayout.setTabRippleColor(ColorStateList.valueOf(android.R.color.transparent));
    }

    @Override
    public int getLayoutId() {
//        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
//        getWindow().setEnterTransition(new Explode());
        return R.layout.activity_main;
    }

    @OnClick({R.id.open_drawerlayout, R.id.search})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.open_drawerlayout:
                drawerlayout.openDrawer(GravityCompat.START);
                break;
            case R.id.search:
                intent.setClass(this, SearchActivity2.class);
                //      startActivity(intent);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                }
                break;
        }
    }

    @SuppressLint("WrongConstant")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        Intent intent = new Intent();
        switch (itemId) {
            case R.id.nav_photo:
                intent.setClass(this, RetrofitActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                } else {
                    startActivity(intent);
                }
                drawerlayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_video:
                intent.setClass(this, GankMoveActivity.class);
                intent.setFlags(flag);
                //      startActivity(intent);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                } else {
                    startActivity(intent);
                }
                drawerlayout.closeDrawer(GravityCompat.START);
                break;


        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // getWindow().setExitTransition(new Slide());
        // getWindow().setExitTransition(new Fade());
    }
}
