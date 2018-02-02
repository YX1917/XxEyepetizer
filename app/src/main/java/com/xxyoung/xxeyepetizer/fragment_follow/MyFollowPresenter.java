package com.xxyoung.xxeyepetizer.fragment_follow;

import com.xxyoung.xxeyepetizer.base.BasePresenter;
import com.xxyoung.xxeyepetizer.base.Callback;
import com.xxyoung.xxeyepetizer.bean.MyFollowBean;

/**
 * Created by yangxing on 2018/2/2.
 */

public class MyFollowPresenter extends BasePresenter<MyFollowView> {
    public void getFollow(String start,String num) {
        if (!isViewAttached()) {
            return;
        }
        getView().showLoading();
        MyFollowModel.getFollow(start,num, new Callback<MyFollowBean>() {
            @Override
            public void onSuccess(MyFollowBean myFollowBean) {
                getView().showFollowData(myFollowBean);
                getView().hideLoading();
            }

            @Override
            public void onFailure(String msg) {
                getView().showToast(msg);
            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
                getView().showErr(e);
            }

            @Override
            public void onComplete() {
                getView().hideLoading();
            }
        });
    }
}
