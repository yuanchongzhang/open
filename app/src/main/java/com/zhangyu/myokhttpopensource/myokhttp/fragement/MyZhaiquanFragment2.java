package com.zhangyu.myokhttpopensource.myokhttp.fragement;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.base.BaseFragment;
import com.zhangyu.myokhttpopensource.myokhttp.response.MyZhaiquanModel;
import com.zhangyu.myokhttpopensource.myokhttp.response.MyZhaiquanShaixuan;
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

public class MyZhaiquanFragment2 extends BaseFragment implements View.OnClickListener {


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

    private List<MyZhaiquanModel.ListBean> newsModel = new ArrayList<>();
    private int mCurrentCounter = 0;

    private View notLoadingView;
    private boolean isErr;
    private Context context;

    private int currentPage;


    private PopupWindow popLeft;
    private View layoutLeft;

    private ListView menulistLeft;
    private ListView menulistLeft2;

    private ListView menulistLeft3;
    private ListView menulistLeft4;

    @Bind(R.id.pop_layout)
    LinearLayout pop_layout;

    List<String> typelist = new ArrayList<>();
    List<String> borrow_interest_rate = new ArrayList<>();

    List<String> borrow_duration = new ArrayList<>();
    List<String> borrow_status = new ArrayList<>();
    String select_id;
    String borrow_interest_rate_id;
    String borrow_duration_id;
    String borrow_status_id;
  //  NewsAdapter newsAdapter2;

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transfer, container, false);
        str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        md5str = MD5Utils.encode("index/index" + "20160001" + str + "24SD%F4}S5").toUpperCase();
        ButterKnife.bind(this, view);
        // getData();
        ll_sp_1.setOnClickListener(this);
        ll_sp_2.setOnClickListener(this);
        ll_sp_3.setOnClickListener(this);
        ll_sp_4.setOnClickListener(this);
        return view;
    }

    public void getData() {
     /*   OkGo.get("http://vhost119.zihaistar.com/api/index/token")//
                .tag(this)//
                .params("client_id", "20160001")
                .params("grant_type", "index/index")
                .params("source_from", "1")
                .params("add_time", str)
                .params("sign_info", md5str)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //  Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();
                        accessToken = s;
                        Log.d(accessToken, "11111111111");
                        Gson gson = new Gson();
                        AccessToken accessToken = new AccessToken();
                        accessToken = gson.fromJson(s, AccessToken.class);
                        Log.d(accessToken.getAccess_token(), "----------------------------");
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });*/
    }

    @Override
    protected void initData() {
        getData();
        //开启loading,获取数据
        setRefreshing(true);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        //newsAdapter = new NewsAdapter(null,newsModel);

    }


    public void setRefreshing(final boolean refreshing) {
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(refreshing);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           /* case R.id.ll_sp_1:

                getData_invest();
                typelist.clear();
                borrow_interest_rate.clear();
                borrow_duration.clear();
                borrow_status.clear();
                break;
            case R.id.ll_sp_2:
                getData_invest();
                borrow_interest_rate.clear();
                typelist.clear();
                borrow_interest_rate.clear();
                borrow_duration.clear();
                borrow_status.clear();
                break;
            case R.id.ll_sp_3:
                getData_invest();
                borrow_duration.clear();
                typelist.clear();
                borrow_interest_rate.clear();
                borrow_duration.clear();
                borrow_status.clear();
                break;
            case R.id.ll_sp_4:
                getData_invest();
                borrow_status.clear();
                typelist.clear();
                borrow_interest_rate.clear();
                borrow_duration.clear();
                borrow_status.clear();
                break;*/
        }
    }


    public void getData_invest() {
        OkGo.get("http://vhost119.zihaistar.com/api/index/invest_filter")//
                .tag(this)//
                .params("access_token", accessToken)

                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //  Toast.makeText(context, "请求成功", Toast.LENGTH_SHORT).show();
                 /*   Gson gson=new Gson();
                        MyZhaiquanShaixuan shaixuan=new MyZhaiquanShaixuan();*/
                        Log.d(s, "daskfjjjjjjjjjjj");

                        Gson gson = new Gson();
                        MyZhaiquanShaixuan shaixuan = new MyZhaiquanShaixuan();
                        shaixuan = gson.fromJson(s, MyZhaiquanShaixuan.class);


                       /* final List<MyZhaiquanShaixuan.BorrowTypeBean> borrow_type;
                        borrow_type = shaixuan.getBorrow_type();

                        Log.d(borrow_type.get(0).getName(), "+++++++++++++++");
                        for (int i = 0; i < borrow_type.size(); i++) {
                            typelist.add(borrow_type.get(i).getName());
                        }

                        layoutLeft = getActivity().getLayoutInflater().inflate(
                                R.layout.pop_menulist, null);
                        menulistLeft = (ListView) layoutLeft
                                .findViewById(R.id.menulist);

                        menulistLeft.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.spinner_list_item, typelist));

                        menulistLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                borrow_interest_rate_id = borrow_type.get(position).getId();
                                // popupWindow.dismiss();
                                typelist.clear();
                                //onRefresh();
                                getData_bond();
                                popLeft.dismiss();
                                typelist.clear();
                            }
                        });
                        popLeft = new PopupWindow(layoutLeft, pop_layout.getWidth(),
                                RelativeLayout.LayoutParams.WRAP_CONTENT);
                        ColorDrawable cd = new ColorDrawable(getResources().getColor(R.color.colorWhite));
//            ColorDrawable cd = new ColorDrawable(-0000);
                        //ColorDrawable cd = new ColorDrawable(0xffff0000);
                        popLeft.setBackgroundDrawable(cd);
                        popLeft.setAnimationStyle(R.style.PopupAnimation);
                        popLeft.update();
                        popLeft.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
                        popLeft.setTouchable(true); // 设置popupwindow可点击
                        popLeft.setOutsideTouchable(true); // 设置popupwindow外部可点击
                        popLeft.setFocusable(true); // 获取焦点
                        popLeft.showAsDropDown(pop_layout, 0, 0);
                        popLeft.setTouchInterceptor(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                // 如果点击了popupwindow的外部，popupwindow也会消失
                                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                                    popLeft.dismiss();
                                    typelist.clear();
                                    borrow_interest_rate.clear();


                                    return true;
                                }
                                return false;
                            }
                        });*/
/*
                        final List<MyZhaiquanShaixuan.BorrowInterestRateBean> borrow_intrestRate;



                        borrow_intrestRate = shaixuan.getBorrow_interest_rate();




                        for (int i = 0; i < borrow_type.size(); i++) {
                            borrow_interest_rate.add(borrow_intrestRate.get(i).getName());
                        }
                        layoutLeft = getActivity().getLayoutInflater().inflate(
                                R.layout.pop_menulist, null);
                        menulistLeft2 = (ListView) layoutLeft
                                .findViewById(R.id.menulist);

                        menulistLeft2.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.spinner_list_item, borrow_interest_rate));

                        menulistLeft2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                select_id = borrow_intrestRate.get(position).getId();
                                // popupWindow.dismiss();
                                borrow_interest_rate.clear();
                                //onRefresh();
                                getData_bond();
                                popLeft.dismiss();
                                borrow_interest_rate.clear();
                            }
                        });

                        final List<MyZhaiquanShaixuan.BorrowDurationBean> borrow_durationBean = shaixuan.getBorrow_duration();

//                        borrow_duration_id

                        for (int i = 0; i < borrow_durationBean.size(); i++) {
                            borrow_duration.add(borrow_durationBean.get(i).getName());
                        }
                        layoutLeft = getActivity().getLayoutInflater().inflate(
                                R.layout.pop_menulist, null);
                        menulistLeft3 = (ListView) layoutLeft
                                .findViewById(R.id.menulist);
                        menulistLeft3.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.spinner_list_item, borrow_duration));

                        menulistLeft3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                borrow_duration_id = borrow_durationBean.get(position).getId();
                                // popupWindow.dismiss();
                                borrow_duration.clear();
                                //onRefresh();
                                getData_bond();
                                popLeft.dismiss();

                            }
                        });


                        final List<MyZhaiquanShaixuan.BorrowStatusBean> borrow_statusBean = shaixuan.getBorrow_status();

//                        borrow_duration_id
                        layoutLeft = getActivity().getLayoutInflater().inflate(
                                R.layout.pop_menulist, null);
                        menulistLeft4 = (ListView) layoutLeft
                                .findViewById(R.id.menulist);
                        for (int i = 0; i < borrow_statusBean.size(); i++) {
                            borrow_status.add(borrow_durationBean.get(i).getName());
                        }
                        menulistLeft4.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.spinner_list_item, borrow_status));

                        menulistLeft4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                borrow_status_id = borrow_statusBean.get(position).getId();
                                // popupWindow.dismiss();
                                borrow_status.clear();
                                //onRefresh();
                                getData_bond();
                                popLeft.dismiss();

                            }
                        });
//                        borrow_status_id


                        popLeft = new PopupWindow(layoutLeft, pop_layout.getWidth(),
                                RelativeLayout.LayoutParams.WRAP_CONTENT);
                        ColorDrawable cd = new ColorDrawable(getResources().getColor(R.color.colorWhite));
//            ColorDrawable cd = new ColorDrawable(-0000);
                        //ColorDrawable cd = new ColorDrawable(0xffff0000);
                        popLeft.setBackgroundDrawable(cd);
                        popLeft.setAnimationStyle(R.style.PopupAnimation);
                        popLeft.update();
                        popLeft.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
                        popLeft.setTouchable(true); // 设置popupwindow可点击
                        popLeft.setOutsideTouchable(true); // 设置popupwindow外部可点击
                        popLeft.setFocusable(true); // 获取焦点
                        popLeft.showAsDropDown(pop_layout, 0, 0);
                        popLeft.setTouchInterceptor(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                // 如果点击了popupwindow的外部，popupwindow也会消失
                                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                                    popLeft.dismiss();
                                    typelist.clear();
                                    borrow_interest_rate.clear();


                                    return true;
                                }
                                return false;
                            }
                        });*/


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


    public void getData_bond() {
      /*  OkGo.get("http://vhost119.zihaistar.com/api/index/bond")//
                .tag(this)//
                .params("access_token", accessToken)
                .params("p", 1)
                .params("borrow_type", select_id)
                .params("borrow_interest_rate", borrow_interest_rate_id)
                .params("borrow_money", borrow_duration_id)
                .params("borrow_duration", borrow_status_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Toast.makeText(context, "筛选成功", Toast.LENGTH_SHORT).show();
                      *//*  typelist.addAll(info.list);
                        nowPage = info.page.nowPage;
                        totalPages = info.page.totalPages;
                        pageSize = info.page.pageSize;
                        totalRows = info.page.totalRows;*//*

                        Gson gson = new Gson();
                        MyZhaiquanModel shaixuan = new MyZhaiquanModel();
                        shaixuan = gson.fromJson(s, MyZhaiquanModel.class);

                        newsModel.clear();
                        newsModel.addAll(shaixuan.getList());


                       *//* newsAdapter2 = new NewsAdapter(shaixuan.getList());
                        recyclerView.setAdapter(newsAdapter2);*//*
                        setRefreshing(true);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }

                    @Override
                    public void onAfter(String s, Exception e) {
                        super.onAfter(s, e);
//                         newsAdapter.setNewData(notify());
                        //  newsAdapter.removeAllFooterView();
                        setRefreshing(false);
                        newsAdapter.notifyDataSetChanged();
                    }
                });*/


    }


}
