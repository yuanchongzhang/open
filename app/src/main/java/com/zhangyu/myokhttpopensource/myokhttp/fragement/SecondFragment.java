package com.zhangyu.myokhttpopensource.myokhttp.fragement;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.base.BaseFragment;
import com.zhangyu.myokhttpopensource.myokhttp.callback.StringDialogCallback;
import com.zhangyu.myokhttpopensource.myokhttp.response.AccessToken;
import com.zhangyu.myokhttpopensource.myokhttp.response.MyZhaiquanModel;
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
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends BaseFragment {

    public String getAccessToken;
    String md5str;
    private String str;

    private Context context;
    private int currentPage;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    private List<MyZhaiquanModel.ListBean> newsModel = new ArrayList<>();
    private int mCurrentCounter = 0;

    private View notLoadingView;
    private boolean isErr;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        md5str = MD5Utils.encode("index/index" + "20160001" + str + "24SD%F4}S5").toUpperCase();
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
       /* recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        newsAdapter = new NewsAdapter(newsModel);
       // mLayoutManager = new LinearLayoutManager(getActivity());

        newsAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        newsAdapter.isFirstOnly(false);
        recyclerView.setAdapter(newsAdapter);

        refreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        refreshLayout.setOnRefreshListener(this);
        newsAdapter.setOnLoadMoreListener(this);
        getData();
        //开启loading,获取数据
        setRefreshing(true);
        onRefresh();*/
    }


    public void getData() {

        OkGo.get("http://vhost119.zihaistar.com/api/index/token")//
                .tag(this)//
                .params("client_id", "20160001")
                .params("grant_type", "index/index")
                .params("source_from", "1")
                .params("add_time", str)
                .params("sign_info", md5str)
                .execute(new StringDialogCallback(getActivity()) {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //  Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();
                        getAccessToken = s;
                        Log.d(getAccessToken, "11111111111");
                        Gson gson = new Gson();

                        AccessToken accessToken = new AccessToken();

                        accessToken = gson.fromJson(s, AccessToken.class);

                        Log.d(accessToken.getAccess_token(), "----------------------------");


                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
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
