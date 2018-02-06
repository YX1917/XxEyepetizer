package com.xxyoung.xxeyepetizer.fragment_follow;

import android.content.Context;

import com.xxyoung.xxeyepetizer.R;
import com.xxyoung.xxeyepetizer.bean.MyFollowBean;
import com.xxyoung.xxeyepetizer.ui.recyclerview.CommonAdapter;
import com.xxyoung.xxeyepetizer.ui.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yangxing on 2018/2/5.
 */

public class MyFollowAdapter extends CommonAdapter<MyFollowBean.FollowListBean> {
    private HashMap<Integer,VideoImgAdapter> mStringVideoImgAdapterHashMap = new HashMap<>();
    private  Context mContext;
    public MyFollowAdapter(Context context, int layoutId, List<MyFollowBean.FollowListBean> datas) {
        super(context, layoutId, datas);
        this.mContext= context;
    }

    @Override
    protected void convert(ViewHolder holder, MyFollowBean.FollowListBean followListBean, int position) {
        holder.setText(R.id.tv_follow_title, followListBean.getFollowDeatil().getHeader().getTitle());
        holder.setText(R.id.tv_follow_description, followListBean.getFollowDeatil().getHeader().getDescription());
        holder.setCircleImg(R.id.img_follow_icon, followListBean.getFollowDeatil().getHeader().getIcon());
        List<MyFollowBean.FollowListBean.followDeatilBean.VideoListBean.VideoDetailBean> mVideoBeanList =new ArrayList<>();
        for (int i = 0; i < followListBean.getFollowDeatil().getVideoListBean().size(); i++) {
            mVideoBeanList.add(followListBean.getFollowDeatil().getVideoListBean().get(i).getVideoDetail());
        }
        mStringVideoImgAdapterHashMap.put(position,new VideoImgAdapter(mContext, R.layout.item_follow_video, mVideoBeanList));
        holder.setAdapter(R.id.recycle_follow_video, mStringVideoImgAdapterHashMap.get(position));
    }

    public class VideoImgAdapter extends CommonAdapter<MyFollowBean.FollowListBean.followDeatilBean.VideoListBean.VideoDetailBean> {
        public VideoImgAdapter(Context context, int layoutId, List<MyFollowBean.FollowListBean.followDeatilBean.VideoListBean.VideoDetailBean> datas) {
            super(context, layoutId, datas);
        }

        @Override
        protected void convert(ViewHolder holder, MyFollowBean.FollowListBean.followDeatilBean.VideoListBean.VideoDetailBean videoDetailBean, int position) {
            holder.setMarginImg(R.id.img_video, videoDetailBean.getCover().getFeed());
            holder.setText(R.id.tv_video_title, videoDetailBean.getTitle());
            holder.setText(R.id.tv_video_category, videoDetailBean.getCategory());
            holder.setLayoutParams(R.id.card_view,32);
        }
    }
}
