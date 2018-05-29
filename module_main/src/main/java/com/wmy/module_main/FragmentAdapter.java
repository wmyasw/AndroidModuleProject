package com.wmy.module_main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.wmy.lib_common.base.BaseFragment;

import java.util.List;

/**
 * @author wmy
 * @Description: 适配器
 * @FileName: FragmentAdapter
 * @Date 2018/5/29/029 11:13
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    private List<BaseFragment> mFragments;

    public FragmentAdapter(FragmentManager fm, List<BaseFragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments != null ? mFragments.size() : 0;
    }

    @Override
    public int getItemPosition(Object object) {
        return android.support.v4.view.PagerAdapter.POSITION_NONE;
    }
}
