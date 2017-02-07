package com.zhangyu.myokhttpopensource.myokhttp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jude.swipbackhelper.SwipeBackHelper;
import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.base.BaseDetailActivity;

/**
 * Created by Administrator on 2017/1/25.
 */

public class ImitationWxActivity extends BaseDetailActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imitationwx);
       /* Fresco.initialize(getApplication());
        JUtils.initialize(getApplication());*/
        SwipeBackHelper.getCurrentPage(ImitationWxActivity.this)
                .setSwipeBackEnable(false);
        SwipeBackHelper.getCurrentPage(this).setDisallowInterceptTouchEvent(true);
        findViewById(R.id.btn_text).setOnClickListener(this);
        findViewById(R.id.btn_scroll).setOnClickListener(this);
        findViewById(R.id.btn_viewpager).setOnClickListener(this);
    }

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_text:
                startActivity(new Intent(this, BannerActivity.class));
                break;
            case R.id.btn_scroll:
                startActivity(new Intent(this, MaterialDesignActivity.class));
                break;
            case R.id.btn_viewpager:
                startActivity(new Intent(this, MyToolBarActivity.class));
                break;
        }
    }
}
