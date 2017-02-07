package com.zhangyu.myokhttpopensource.myokhttp.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;
import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.response.BannerResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */

public class LargePicAdapter2 extends BaseQuickAdapter<BannerResponse.BannerlistBean, BaseViewHolder> {

    public LargePicAdapter2(final List<BannerResponse.BannerlistBean> data) {
        super(R.layout.chakandatu, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BannerResponse.BannerlistBean item) {
        // helper.setText(R.id.tv_name, item.getPicurl());
        /*String string = "http://121.42.26.208:83/" + item.getPicurl();
        //   Glide.with(mContext).load(string.crossFade().into((ImageView) helper.getView(R.id.img_largePic));
        Glide.with(mContext).load(string).into((ImageView) helper.getView(R.id.img_largePic));*/
        ArrayList<ImageInfo> imageInfo = new ArrayList<>();
        NineGridView nineGrid = helper.getView(R.id.nineGrid);
        List<BannerResponse.BannerlistBean> imageDetails = getData();
        for (int i = 0; i < 5; i++) {
            ImageInfo info = new ImageInfo();
            info.setThumbnailUrl("http://121.42.26.208:83/" + imageDetails.get(i).getPicurl());
            info.setBigImageUrl("http://121.42.26.208:83/" + imageDetails.get(i).getPicurl());
            imageInfo.add(info);
        }
      /*  ImageInfo info = new ImageInfo();
        info.setThumbnailUrl("http://121.42.26.208:83/"+item.getPicurl());
        info.setBigImageUrl("http://121.42.26.208:83/"+item.getPicurl());
        imageInfo.add(info);*/


        nineGrid.setAdapter(new NineGridViewClickAdapter(mContext, imageInfo));

        if (imageDetails != null && imageDetails.size() == 1) {
            // nineGrid.setSingleImageRatio(imageDetails.get(0).width * 1.0f / imageDetails.get(0).height);
            nineGrid.setSingleImageRatio(100 * 1.0f / 100);
        }


    }

}
