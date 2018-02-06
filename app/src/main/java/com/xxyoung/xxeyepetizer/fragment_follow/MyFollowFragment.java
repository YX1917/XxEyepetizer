package com.xxyoung.xxeyepetizer.fragment_follow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xxyoung.xxeyepetizer.R;
import com.xxyoung.xxeyepetizer.base.BaseFragment;
import com.xxyoung.xxeyepetizer.bean.MyFollowBean;
import com.xxyoung.xxeyepetizer.ui.recyclerview.CommonAdapter;
import com.xxyoung.xxeyepetizer.ui.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

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
    private CommonAdapter<MyFollowBean.FollowListBean> mFollowListBeanCommonAdapter;
    private LoadMoreWrapper mLoadMoreWrapper;
    private List<MyFollowBean.FollowListBean> mAuthorListBeen = new ArrayList<>();
    private int startId = 2;

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
        initRecycleView();
        mMyFollowPresenter = new MyFollowPresenter();
        mMyFollowPresenter.attachView(this);
        mMyFollowPresenter.getFollow("0", "2");
    }

    private void initRecycleView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecycleFollow.setLayoutManager(linearLayoutManager);
        mFollowListBeanCommonAdapter = new MyFollowAdapter(getActivity(), R.layout.item_follow, mAuthorListBeen);
        mLoadMoreWrapper = new LoadMoreWrapper(mFollowListBeanCommonAdapter);
        mLoadMoreWrapper.setLoadMoreView(R.layout.default_loading_recycle);
        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mMyFollowPresenter.getFollow(String.valueOf(startId), "2");
                startId = startId + 2;
            }
        });

        mRecycleFollow.setAdapter(mLoadMoreWrapper);
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
        for (MyFollowBean.FollowListBean followListBean : myFollowBean.getFollowList()) {
            mAuthorListBeen.add(followListBean);
        }
        mLoadMoreWrapper.notifyDataSetChanged();

    }
}
