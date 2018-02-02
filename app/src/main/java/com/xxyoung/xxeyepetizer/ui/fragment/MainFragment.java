package com.xxyoung.xxeyepetizer.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.xxyoung.xxeyepetizer.R;
import com.xxyoung.xxeyepetizer.SimpleCardFragment;
import com.xxyoung.xxeyepetizer.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yangxing on 2018/2/2.
 */

public class MainFragment extends BaseFragment {
    @BindView(R.id.vp_fragment)
    ViewPager mVpFragment;
    @BindView(R.id.stl_fragment_top)
    SlidingTabLayout mStlFragmentTop;
    Unbinder unbinder;

    private final String[] mTitles = {
            "发现", "推荐", "日报"
            , "音乐", "旅行", "科普", "搞笑"
    };

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private MyPagerAdapter mAdapter;


    private String mTitle;

    public static MainFragment getInstance(String title) {
        MainFragment sf = new MainFragment();
        sf.mTitle = title;
        return sf;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_main;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }
        mAdapter = new MyPagerAdapter(getChildFragmentManager());
        mVpFragment.setAdapter(mAdapter);
        mStlFragmentTop.setViewPager(mVpFragment, mTitles);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
