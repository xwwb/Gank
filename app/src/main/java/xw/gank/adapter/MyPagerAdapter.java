package xw.gank.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/27.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment>mFragments;
    private String [] titleString;

    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> mFragments, String[] titleString) {
        super(fm);
        this.mFragments = mFragments;
        this.titleString = titleString;
    }

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleString[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
}

