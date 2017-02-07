package com.zhangyu.myokhttpopensource.myokhttp.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.model.NewZhaiquan;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */

public class MyNewZhaiquanAdapter extends BaseQuickAdapter<NewZhaiquan.ListBean, BaseViewHolder> {
    public MyNewZhaiquanAdapter(List<NewZhaiquan.ListBean> data) {
        super(R.layout.list_18_item_view_beifen,data);
    }


/*    public MyNewZhaiquanAdapter(int layoutResId, List<NewZhaiquan.ListBean> data) {
        super(R.layout.list_18_item_view_beifen, data);
    }*/

    @Override
    protected void convert(BaseViewHolder helper, NewZhaiquan.ListBean item) {
        helper.setText(R.id.tv_name, item.getBorrow_name());
        helper.setText(R.id.tv_sumMoney, item.getMoney());
        helper.setText(R.id.text_tranfour, item.getStatus());
        helper.setText(R.id.tv_07, item.getBorrow_interest_rate());
        helper.setText(R.id.tv_06, item.getPeriod_cn());
        helper.setText(R.id.tv_08, item.getTransfer_price());
    }
}
