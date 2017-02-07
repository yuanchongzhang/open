package com.zhangyu.myokhttpopensource.myokhttp.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.base.BaseDetailActivity;
import com.zhangyu.myokhttpopensource.myokhttp.response.BannerResponse;
import com.zhangyu.myokhttpopensource.myokhttp.tupianlunbozu.GridViewAdapter;
import com.zhangyu.myokhttpopensource.myokhttp.tupianlunbozu.Model;
import com.zhangyu.myokhttpopensource.myokhttp.tupianlunbozu.ViewPagerAdapter;
import com.zhangyu.myokhttpopensource.myokhttp.util.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/1/16.
 */

public class BannerActivity2 extends BaseDetailActivity {
    BannerLayout banner2;

    private String[] titles = {"美食", "电影", "酒店住宿", "休闲娱乐", "外卖", "自助餐", "KTV", "机票/火车票", "周边游", "美甲美睫",
            "火锅", "生日蛋糕", "甜品饮品", "水上乐园", "汽车服务", "美发", "丽人", "景点", "足疗按摩", "运动健身", "健身", "超市", "买菜",
            "今日新单", "小吃快餐", "面膜", "洗浴/汗蒸", "母婴亲子", "生活服务", "婚纱摄影", "学习培训", "家装", "结婚", "全部分配"};


    //ViewPager
    private ViewPager mViewPager;
    //点
    private LinearLayout mLlDot;
    private List<Model> mDatas;
    private LayoutInflater mInflater;
    private List<GridView> mPagerList;
    //规定每页的大小为 10
    private int pageSize = 10;
    //页数
    private int mPageCount;
    //当前是第几页
    private int mCurrIndex;
    private GridView mGridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        banner2 = (BannerLayout) findViewById(R.id.banner2);
        initView();
        //初始化数据
        initData();
        //设置圆点
        setOvlDot();
    }

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        getData();
    }

    public void getData() {
        OkGo.get("http://121.42.26.208:83/interface/json_index.php?areaid=1&page=1&uid=")//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Toast.makeText(BannerActivity2.this, "请求成功", Toast.LENGTH_SHORT).show();
                        Log.d(s, "dasfjkjkjkjkjkjkjkjkl");
                        // BannerResponse.BannerlistBean bannerlistBean=new BannerResponse.BannerlistBean();

                        BannerResponse bannerResponse = new BannerResponse();
                        Gson gson = new Gson();

                        bannerResponse = gson.fromJson(s, BannerResponse.class);

                        List<BannerResponse.BannerlistBean> bannerlistBean = new ArrayList<BannerResponse.BannerlistBean>();
                        bannerlistBean = bannerResponse.getBannerlist();
                        List<String> strings = new ArrayList<String>();


                        for (int i = 0; i < bannerlistBean.size(); i++) {
                            //banner2.add("http://121.42.26.208:83/"+mEnjoyLists.get(i).getPicurl());
                            strings.add("http://121.42.26.208:83/" + bannerlistBean.get(i).getPicurl());
                        }

                        banner2.setViewUrls(strings);
                        banner2.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                Toast.makeText(BannerActivity2.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });
    }





    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mLlDot = (LinearLayout) findViewById(R.id.ll_dot);
    }

    private void initData() {
        //数据源,把数据封装到集合
        mDatas = new ArrayList<>();
        //存的是GridView
        mPagerList = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            //动态获取图片的资源id
            int imageId = getResources().getIdentifier("ic_category_" + i, "mipmap", getPackageName());
            mDatas.add(new Model(titles[i], imageId));
        }
        //填充器
        mInflater = LayoutInflater.from(this);
        //为GridView分页
        //总的页数 = 总的条目数  /  每页的条目数，并取整
        mPageCount = (int) Math.ceil(mDatas.size() * 1.0 / pageSize);

        for (int i = 0; i < mPageCount; i++) {
            mGridView = (GridView) mInflater.inflate(R.layout.gridview, mViewPager, false);
            mGridView.setAdapter(new GridViewAdapter(this, mDatas, i, pageSize));
            mPagerList.add(mGridView);
            initListener(i);
        }

        //为ViewPager设置适配器
        mViewPager.setAdapter(new ViewPagerAdapter(mPagerList));

    }

    private void initListener(final int currIndex) {
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = position + currIndex * pageSize;
                Toast.makeText(BannerActivity2.this, mDatas.get(pos).appName + "---" + pos, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setOvlDot() {
        //有几页就有几个点
        for (int i = 0; i < mPageCount; i++) {
            mLlDot.addView(mInflater.inflate(R.layout.dot, null));
        }
        //默认选中第一个点
        mLlDot.getChildAt(0).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.dot_selected);

        //当ViewPager滑动的时候换点
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //先取消选中一个点
                mLlDot.getChildAt(mCurrIndex).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.dot_normal);
                //在选中
                mLlDot.getChildAt(position).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.dot_selected);
                mCurrIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public void onClick(View v) {

    }
}
