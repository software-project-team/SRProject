package com.yunuscagliyan.socialreader.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that stores fragments for tabs
 */

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = "SectionsPagerAdapter";
    private final List<Fragment> mFragmentList=new ArrayList<>();
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    public void addFragment(Fragment fragment){
        mFragmentList.add(fragment);

    }
}