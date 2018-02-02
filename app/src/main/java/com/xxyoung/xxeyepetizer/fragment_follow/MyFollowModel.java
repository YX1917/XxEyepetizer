package com.xxyoung.xxeyepetizer.fragment_follow;

import com.xxyoung.xxeyepetizer.base.Callback;
import com.xxyoung.xxeyepetizer.bean.MyFollowBean;
import com.xxyoung.xxeyepetizer.net.ApiCall;
import com.xxyoung.xxeyepetizer.net.RetrofitManger;
import com.xxyoung.xxeyepetizer.utilcode.util.LogUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yangxing on 2018/2/2.
 */

public class MyFollowModel {
    public static void getFollow(String start, String num, final Callback<MyFollowBean> callback) {
        RetrofitManger.getInstance()
                .createReq(ApiCall.class)
                .getFollow(start, num)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MyFollowBean>() {
                    @Override
                    public void onCompleted() {
                        callback.onComplete();
                        LogUtils.e("onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                        LogUtils.e(e.getMessage());
                    }


                    @Override
                    public void onNext(MyFollowBean myFollowBean) {
                        callback.onSuccess(myFollowBean);
                        LogUtils.e(myFollowBean.toString());
                    }
                });
    }
}
