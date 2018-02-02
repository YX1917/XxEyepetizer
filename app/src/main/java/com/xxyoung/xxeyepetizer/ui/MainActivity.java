package com.xxyoung.xxeyepetizer.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.xxyoung.xxeyepetizer.R;
import com.xxyoung.xxeyepetizer.SimpleCardFragment;
import com.xxyoung.xxeyepetizer.bean.tabEntity.TabEntity;
import com.xxyoung.xxeyepetizer.fragment_follow.MyFollowFragment;
import com.xxyoung.xxeyepetizer.ui.fragment.MainFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.ctl_bottom_tab)
    CommonTabLayout mCommonTabLayout;

    private String[] mTitles = {"首页", "关注", "通知", "我的"};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private int[] mIconUnselectIds = {
            R.drawable.ic_tab_strip_icon_feed, R.drawable.ic_tab_strip_icon_follow,
            R.drawable.ic_tab_strip_icon_category, R.drawable.ic_tab_strip_icon_profile};
    private int[] mIconSelectIds = {
            R.drawable.ic_tab_strip_icon_feed_selected, R.drawable.ic_tab_strip_icon_follow_selected,
            R.drawable.ic_tab_strip_icon_category_selected, R.drawable.ic_tab_strip_icon_profile_selected};
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initBottomTab();
    }


    private void initBottomTab() {

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mFragments.add(MainFragment.getInstance("Switch ViewPager " + mTitles[0]));
        mFragments.add(new MyFollowFragment());
        mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager " + mTitles[2]));
        mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager " + mTitles[3]));

        mCommonTabLayout.setTabData(mTabEntities, this, R.id.fl_change, mFragments);
        mCommonTabLayout.setCurrentTab(0);

    }

}
