package com.xxyoung.xxeyepetizer.fragment_follow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xxyoung.xxeyepetizer.R;
import com.xxyoung.xxeyepetizer.base.BaseFragment;
import com.xxyoung.xxeyepetizer.bean.MyFollowBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yangxing on 2018/2/2.
 */

public class MyFollowFragment extends BaseFragment implements MyFollowView {
    @BindView(R.id.recycle_follow)
    RecyclerView mRecycleFollow;
    Unbinder unbinder;
    private MyFollowPresenter mMyFollowPresenter;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_follow;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMyFollowPresenter= new MyFollowPresenter();
        mMyFollowPresenter.attachView(this);
        mMyFollowPresenter.getFollow("0","2");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 显示正在加载view
     */
    @Override
    public void showLoading() {

    }

    /**
     * 关闭正在加载view
     */
    @Override
    public void hideLoading() {

    }

    /**
     * 显示提示
     *
     * @param msg
     */
    @Override
    public void showToast(String msg) {

    }

    /**
     * 显示请求错误提示
     *
     * @param e
     */
    @Override
    public void showErr(Throwable e) {

    }

    @Override
    public void showFollowData(MyFollowBean myFollowBean) {

    }
}
