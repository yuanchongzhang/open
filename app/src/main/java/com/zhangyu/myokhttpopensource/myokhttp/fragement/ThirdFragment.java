package com.zhangyu.myokhttpopensource.myokhttp.fragement;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.adapter.ZhaiquanAdapter;
import com.zhangyu.myokhttpopensource.myokhttp.base.BaseFragment;
import com.zhangyu.myokhttpopensource.myokhttp.callback.StringDialogCallback;
import com.zhangyu.myokhttpopensource.myokhttp.response.AccessToken;
import com.zhangyu.myokhttpopensource.myokhttp.response.Zhaiquan;
import com.zhangyu.myokhttpopensource.myokhttp.util.MD5Utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends BaseFragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {


    ZhaiquanAdapter adapter;


    public String getAccessToken;
    String md5str;
    private String str;
    private List<Zhaiquan.ListBean> list = new ArrayList<>();

    private RecyclerView rv_01;
    private RecyclerView.LayoutManager mLayoutManager;
    AccessToken accessToken;
    Gson gson;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, null);
        gson = new Gson();
        rv_01 = (RecyclerView) view.findViewById(R.id.rv_01);


        str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        md5str = MD5Utils.encode("index/index" + "20160001" + str + "24SD%F4}S5").toUpperCase();
        getData();

        getData2();

        return view;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    protected void initData() {

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
                        accessToken = gson.fromJson(s, AccessToken.class);
                        getAccessToken = accessToken.getAccess_token();
                        Log.d(accessToken.getAccess_token(), "----------------------------");


                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }

                    @Override
                    public void onAfter(@Nullable String s, @Nullable Exception e) {
                        super.onAfter(s, e);
                        getAccessToken = accessToken.getAccess_token();
                    }
                });

    }


    public void getData2() {

        OkGo.get("http://vhost119.zihaistar.com/api/index/bond")//
                .tag(this)//
                .params("access_token", getAccessToken)
                .params("p", "0")
                .params("borrow_type", "0")
                .params("borrow_interest_rate", 0)
                .params("borrow_money", 0)
                .params("borrow_duration", 0)
         /*   .execute(new DialogCallback<LzyResponse<Zhaiquan>>(getActivity()) {

                @Override
                public void onSuccess(LzyResponse<Zhaiquan> zhaiquanzyResponse, Call call, Response response) {
                    Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();
                }
            });*/
                .execute(new StringDialogCallback(getActivity()) {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //   Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();
                        Log.d(s, "dasklffffffffffff");
                        Gson gson = new Gson();
                        Zhaiquan zhaiquan = new Zhaiquan();
                        zhaiquan = gson.fromJson(s, Zhaiquan.class);
                        list = zhaiquan.getList();
                        adapter = new ZhaiquanAdapter(getActivity(), list);
                        mLayoutManager = new LinearLayoutManager(getActivity());
                        rv_01.setLayoutManager(mLayoutManager);
//        Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.line_divider);
//        rv01.addItemDecoration(new SimpleDividerItemDecoration(getActivity(), drawable, 40));
                        rv_01.setAdapter(adapter);
//                        list
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
