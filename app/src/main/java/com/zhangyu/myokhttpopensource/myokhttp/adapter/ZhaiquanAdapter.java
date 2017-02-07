package com.zhangyu.myokhttpopensource.myokhttp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.response.Zhaiquan;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2017/1/12.
 */
public class ZhaiquanAdapter extends RecyclerView.Adapter<ZhaiquanAdapter.ViewHolder> {


    private Context context;
    private List<Zhaiquan.ListBean> list;

    public ZhaiquanAdapter(Context context, List<Zhaiquan.ListBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     /*   View view = BoundViewHelper.boundView(this, MyApplication.scaleScreenHelper.loadView((ViewGroup) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_18_item_view_beifen, null)));*/
        View view = LayoutInflater.from(context).inflate(R.layout.list_18_item_view_beifen, null);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvName.setText("项目名称" + list.get(position).getBorrow_name());
        holder.tvSumMoney.setText(list.get(position).getNeed() + "元");
        holder.tv06.setText(list.get(position).getBorrow_name() + "元");

        holder.tv07.setText(list.get(position).getId() + list.get(position).getBorrow_name() + "天");
        holder.tv08.setText(list.get(position).getBorrow_name() + "%");
        holder.tvName.setText(list.get(position).getProgress());
        // holder.text_tranfour.setText(list.get(position).status);
        String string = list.get(position).getNeed();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_06)
        TextView tv06;

        @Bind(R.id.tv_07)
        TextView tv07;
        @Bind(R.id.tv_08)
        TextView tv08;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_sumMoney)
        TextView tvSumMoney;
        @Bind(R.id.text_tranfour)
        TextView text_tranfour;

        /*    @Bind(R.id.progress_horizontal)
            ProgressBar progress_horizontal;*/
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
