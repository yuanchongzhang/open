package com.zhangyu.myokhttpopensource.myokhttp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.base.BaseDetailActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/20.
 */
public class MaterialDesignActivity extends BaseDetailActivity {

    @Bind(R.id.table_layout)
    Button table_layout;
    @Bind(R.id.table_recycleview)
    Button  table_recycleview;

    @Bind(R.id.table_Jsoncallback)
    Button table_Jsoncallback;

    @Bind(R.id.table_EasyRecycleview)
    Button table_EasyRecycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materialdesign);
        ButterKnife.bind(this);
      /*  setTitleName("materialdesign");//title
        //setTitleBack(false,R.mipmap.ic_back);//有图标，但不是返回
        setTitleBack(false, 0);//返回
        setTitleRightText("保存");//右侧文字*/
        setTitleName("Android 5.0");//title
        setTitleBack(false, R.mipmap.ic_back);//有图标，但不是返回
        setTitleBack(true, 1);//返回
        setTitleRightText("保存");//右侧文字
        table_layout.setOnClickListener(this);
        table_recycleview.setOnClickListener(this);
        table_Jsoncallback.setOnClickListener(this);
        table_EasyRecycleview.setOnClickListener(this);
    }

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.table_layout:
//                Toast.makeText(this, "aaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(MaterialDesignActivity.this, TableLayoutActivity.class));
                break;

            case R.id.title_back:
                Toast.makeText(this, "点击了返回按钮", Toast.LENGTH_SHORT).show();
                finish();

                break;

            case R.id.title_rightTv:
                Toast.makeText(this, "点击了右键", Toast.LENGTH_SHORT).show();
                break;
            case R.id.table_recycleview:
                startActivity(new Intent(MaterialDesignActivity.this, RecycleViewActivity.class));
                break;

            case R.id.table_Jsoncallback:
                startActivity(new Intent(MaterialDesignActivity.this, JsonCallBackActivity.class));

                break;

            case R.id.table_EasyRecycleview:
           //     startActivity(new Intent(MaterialDesignActivity.this, EasyRecycleViewActivity.class));

                break;


        }
    }
}
