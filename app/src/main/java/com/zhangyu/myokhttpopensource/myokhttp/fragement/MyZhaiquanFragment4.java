package com.zhangyu.myokhttpopensource.myokhttp.fragement;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.adapter.MyNewZhaiquanAdapter;
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

import static android.nfc.tech.MifareUltralight.PAGE_SIZE;

/**
 * Created by Administrator on 2017/1/20.
 */

public class MyZhaiquanFragment4 extends Fragment implements View.OnClickListener, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {


    private String md5str;
    private String str;
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

    public static List<NewZhaiquan.ListBean> newsModel;
    private Context context;

    private static MyNewZhaiquanAdapter myNewZhaiquanAdapter;
    private boolean isErr;
    private int mCurrentCounter = 0;
    NewZhaiquan newZhaiquan;
    Gson gson;
    AccessToken getAccessToken;
    private String getData;
    private static String getAccToken;
    private boolean mLoadMoreEndGone = false;

    private View notDataView;
    private View errorView;

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_transfer, container, false);
        str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        md5str = MD5Utils.encode("index/index" + "20160001" + str + "24SD%F4}S5").toUpperCase();
        ButterKnife.bind(this, view);
        gson = new Gson();
        newZhaiquan = new NewZhaiquan();
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // getData();
        notDataView = getActivity().getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) recyclerView.getParent(), false);
        notDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });
        errorView = getActivity().getLayoutInflater().inflate(R.layout.error_view, (ViewGroup) recyclerView.getParent(), false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });
        getData();

        initAdapter();
        onRefresh();
        setRefreshing(true);
        return view;

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
                        AccessToken getAccessToken = new AccessToken();
                        Gson gson = new Gson();
                        getAccessToken = gson.fromJson(s, AccessToken.class);
                        getAccToken = getAccessToken.getAccess_token();

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });

    }


    public void getZhaiqistData() {
        OkGo.post("http://vhost119.zihaistar.com/api/index/bond")//
                .tag(this)//
                .params("access_token", getAccToken)
                .params("p", "0")
                .params("borrow_type", "0")
                .params("borrow_interest_rate", 0)
                .params("borrow_money", 0)
                .params("borrow_duration", 0)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();
                        newsModel = new ArrayList<NewZhaiquan.ListBean>();
                        newZhaiquan = gson.fromJson(s, NewZhaiquan.class);
                        newsModel = newZhaiquan.getList();
                        mCurrentCounter = newsModel.size();
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }

                    @Override
                    public void onAfter(String s, Exception e) {
                        super.onAfter(s, e);

                    }
                });
    }

    private boolean mError = true;
    private boolean mNoData = true;

    @Override
    public void onClick(View v) {
       /* switch (v.getId()) {

        }*/
        mError = true;
        mNoData = true;
        myNewZhaiquanAdapter.setNewData(null);
        onRefresh();
    }


    @Override
    public void onRefresh() {
    //    myNewZhaiquanAdapter.setEmptyView(R.layout.loading_view, (ViewGroup) refreshLayout.getParent());


        Toast.makeText(context, "刷新成功", Toast.LENGTH_SHORT).show();

        getZhaiqistData();

        myNewZhaiquanAdapter.setEnableLoadMore(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isErr) {
                    myNewZhaiquanAdapter
                            .setEmptyView(errorView);
                    mError = false;
                } else if (mNoData) {
                    myNewZhaiquanAdapter.setEmptyView(notDataView);
                    mNoData = false;
                } else {
                    myNewZhaiquanAdapter.setNewData(newsModel);
                    isErr = false;
                    mCurrentCounter = PAGE_SIZE;
                    refreshLayout.setRefreshing(false);
                    myNewZhaiquanAdapter.setEnableLoadMore(true);
                    myNewZhaiquanAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                }
            }
        }, 1000);

        //myNewZhaiquanAdapter.notifyDataSetChanged();
    }
    @Override
    public void onLoadMoreRequested() {
        //  Toast.makeText(context, "heheda", Toast.LENGTH_SHORT).show();
        getZhaiqistData();
        refreshLayout.setEnabled(false);
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (myNewZhaiquanAdapter.getData().size() < newsModel.size()) {
                    myNewZhaiquanAdapter.loadMoreEnd(true);
                } else {
                    if (mCurrentCounter >= newsModel.size()) {
//                    pullToRefreshAdapter.loadMoreEnd();//default visible
                        myNewZhaiquanAdapter.loadMoreEnd(mLoadMoreEndGone);//true is gone,false is visible
                    } else {
                        if (isErr) {
                            myNewZhaiquanAdapter.addData(newsModel);
                            mCurrentCounter = myNewZhaiquanAdapter.getData().size();
                            myNewZhaiquanAdapter.loadMoreComplete();
                        } else {
                            isErr = true;
                            Toast.makeText(getActivity(), "网络不给力", Toast.LENGTH_LONG).show();
                            myNewZhaiquanAdapter.loadMoreFail();
                        }
                    }
                    refreshLayout.setEnabled(true);
                }
            }

        }, 1000);

    }


    private void initAdapter() {
        refreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        myNewZhaiquanAdapter = new MyNewZhaiquanAdapter(newsModel);
        myNewZhaiquanAdapter.isFirstOnly(false);
        myNewZhaiquanAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);

        recyclerView.setAdapter(myNewZhaiquanAdapter);
        //  setRefreshing(true);
        myNewZhaiquanAdapter.setOnLoadMoreListener(MyZhaiquanFragment4.this);
        recyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(final BaseQuickAdapter adapter, final View view, final int position) {
                Toast.makeText(getActivity(), Integer.toString(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setRefreshing(final boolean refreshing) {
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(refreshing);
            }
        });
    }
}



