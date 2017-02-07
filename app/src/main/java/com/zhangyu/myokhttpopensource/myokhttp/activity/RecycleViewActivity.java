package com.zhangyu.myokhttpopensource.myokhttp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.adapter.MyNewZhaiquanAdapter;
import com.zhangyu.myokhttpopensource.myokhttp.base.BaseDetailActivity;
import com.zhangyu.myokhttpopensource.myokhttp.model.NewZhaiquan;
import com.zhangyu.myokhttpopensource.myokhttp.response.AccessToken;
import com.zhangyu.myokhttpopensource.myokhttp.util.MD5Utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/1/20.
 */
public class RecycleViewActivity extends BaseDetailActivity {


    private String md5str;
    private String str;
    private String accessToken;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @Bind(R.id.ll_sp_1)
    LinearLayout ll_sp_1;
    @Bind(R.id.ll_sp_2)
    LinearLayout ll_sp_2;
    @Bind(R.id.ll_sp_3)
    LinearLayout ll_sp_3;
    @Bind(R.id.ll_sp_4)
    LinearLayout ll_sp_4;

    public List<NewZhaiquan.ListBean> newsModel;
    private Context context;

    private MyNewZhaiquanAdapter myNewZhaiquanAdapter;
    private boolean isErr;
    private int mCurrentCounter = 0;
    NewZhaiquan newZhaiquan ;
    Gson gson;
    private String getStringData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_transfer);
        ButterKnife.bind(this);
      /*  setTitleName("materialdesign");//title
        //setTitleBack(false,R.mipmap.ic_back);//有图标，但不是返回
        setTitleBack(false, 0);//返回
        setTitleRightText("保存");//右侧文字*/
        setTitleName("Android 5.0");//title
        setTitleBack(false, R.mipmap.ic_back);//有图标，但不是返回
        setTitleBack(true, 1);//返回
        setTitleRightText("保存");//右侧文字
        str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        md5str = MD5Utils.encode("index/index" + "20160001" + str + "24SD%F4}S5").toUpperCase();
        ButterKnife.bind(this);
        gson = new Gson();
        newZhaiquan = new NewZhaiquan();
        // getData();
        newsModel = new ArrayList<>();
        getData();
        getZhaiquanListData();

    }

    public void getData() {
        OkGo.post("http://vhost119.zihaistar.com/api/index/token")
                .tag(this)
                .params("client_id", "20160001")
                .params("grant_type", "index/index")
                .params("source_from", "1")
                .params("add_time", str)
                .params("sign_info", md5str)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        Gson gson = new Gson();
                        AccessToken getAccessToken = new AccessToken();
                        getAccessToken = gson.fromJson(s, AccessToken.class);
                        accessToken = getAccessToken.getAccess_token();

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });

    }



    public void getZhaiquanListData() {

        OkGo.post("http://vhost119.zihaistar.com/api/index/bond")//
                .tag(this)//
                .params("access_token", accessToken)
                .params("p", "0")
                .params("borrow_type", "0")
                .params("borrow_interest_rate", 0)
                .params("borrow_money", 0)
                .params("borrow_duration", 0)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Toast.makeText(RecycleViewActivity.this, "请求成功", Toast.LENGTH_SHORT).show();


                        newZhaiquan = gson.fromJson(s, NewZhaiquan.class);

                        newsModel = newZhaiquan.getList();

                        myNewZhaiquanAdapter = new MyNewZhaiquanAdapter(newsModel);

                        recyclerView.setLayoutManager(new LinearLayoutManager(RecycleViewActivity.this));
                        recyclerView.setAdapter(myNewZhaiquanAdapter);

                      /*  recyclerView.addOnItemTouchListener(new OnItemClickListener() {
                            @Override
                            public void onSimpleItemClick(final BaseQuickAdapter adapter, final View view, final int position) {
                                Toast.makeText(getActivity(), Integer.toString(position), Toast.LENGTH_LONG).show();
                            }
                        });*/
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });
    }

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}
