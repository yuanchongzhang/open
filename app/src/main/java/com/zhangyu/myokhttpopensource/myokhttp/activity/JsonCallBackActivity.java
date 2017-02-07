package com.zhangyu.myokhttpopensource.myokhttp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.base.BaseDetailActivity;
import com.zhangyu.myokhttpopensource.myokhttp.callback.DialogCallback;
import com.zhangyu.myokhttpopensource.myokhttp.model.Contains;
import com.zhangyu.myokhttpopensource.myokhttp.model.ZhaiQuanReSponse;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

import static com.zhangyu.myokhttpopensource.R.id.table_layout;

/**
 * Created by Administrator on 2017/1/20.
 */
public class JsonCallBackActivity extends BaseDetailActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsoncallback);
        ButterKnife.bind(this);
      /*  setTitleName("materialdesign");//title
        //setTitleBack(false,R.mipmap.ic_back);//有图标，但不是返回
        setTitleBack(false, 0);//返回
        setTitleRightText("保存");//右侧文字*/
        setTitleName("Android 5.0");//title
        setTitleBack(false, R.mipmap.ic_back);//有图标，但不是返回
        setTitleBack(true, 1);//返回
        setTitleRightText("jsoncallback");//右侧文字

        getZhaiqistData();
    }


    public void getZhaiqistData() {
        OkGo.post("http://vhost119.zihaistar.com/api/index/bond")//
                .tag(this)//
                .params("access_token", "123456")
                .params("p", "0")
                .params("borrow_type", "0")
                .params("borrow_interest_rate", 0)
                .params("borrow_money", 0)
                .params("borrow_duration", 0)
                .execute(new DialogCallback<ZhaiQuanReSponse<Contains>>(this) {
                    @Override
                    public void onSuccess(ZhaiQuanReSponse<Contains> containsZhaiQuanReSponse, Call call, Response response) {
                        Toast.makeText(JsonCallBackActivity.this, "成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        Toast.makeText(JsonCallBackActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
               /* .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Toast.makeText(JsonCallBackActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
                        *//*newsModel = new ArrayList<NewZhaiquan.ListBean>();
                        newZhaiquan = gson.fromJson(s, NewZhaiquan.class);
                        newsModel = newZhaiquan.getList();
                        mCurrentCounter = newsModel.size();*//*
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);

                    }

                    @Override
                    public void onAfter(String s, Exception e) {
                        super.onAfter(s, e);
                        myNewZhaiquanAdapter.setEmptyView(R.layout.error_view, (ViewGroup) recyclerView.getParent());
                    }
                });*/
    }


    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case table_layout:
//                Toast.makeText(this, "aaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(JsonCallBackActivity.this, TableLayoutActivity.class));
                break;

            case R.id.title_back:
                Toast.makeText(this, "点击了返回按钮", Toast.LENGTH_SHORT).show();
                finish();

                break;

            case R.id.title_rightTv:
                Toast.makeText(this, "点击了右键", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
