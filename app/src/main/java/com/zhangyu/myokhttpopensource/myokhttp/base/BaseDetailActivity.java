package com.zhangyu.myokhttpopensource.myokhttp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.swipbackhelper.SwipeBackHelper;
import com.zhangyu.myokhttpopensource.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;


public abstract class BaseDetailActivity extends BaseActivity implements View.OnClickListener {

    protected ActionBar actionBar;

    protected FrameLayout rootContent;
    Toolbar toolbar;
    TextView title_name;

    /*是否第一次加载返回*/
    private boolean title_back_first = true;
    /*是否是返回(有可能是代表别的功能)*/
    private boolean is_title_back = true;
    ImageView title_back;
    TextView textView;

    private static final String LAYOUT_LINEARLAYOUT = "LinearLayout";
    private static final String LAYOUT_FRAMELAYOUT = "FrameLayout";
    private static final String LAYOUT_RELATIVELAYOUT = "RelativeLayout";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeBackEnable(true)
                .setSwipeSensitivity(0.5f)
                .setSwipeRelateEnable(true)
                .setSwipeRelateOffset(300);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        getDelegate().setContentView(R.layout.activity_base);

        Window window = getWindow();

        rootContent = (FrameLayout) window.findViewById(R.id.content);
        toolbar = (Toolbar) window.findViewById(R.id.toolbar);
        title_name = (TextView) window.findViewById(R.id.title_name);
        title_back = (ImageView) window.findViewById(R.id.title_back);
        title_back.setOnClickListener(this);
        textView = (TextView) window.findViewById(R.id.title_rightTv);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        onActivityCreate(savedInstanceState);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
        //ViewServer.get(this).removeWindow(this);
    }

    public void onResume() {
        super.onResume();
        //ViewServer.get(this).setFocusedWindow(this);
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {

        View view = null;
        if (name.equals(LAYOUT_FRAMELAYOUT)) {
            view = new AutoFrameLayout(context, attrs);
        }

        if (name.equals(LAYOUT_LINEARLAYOUT)) {
            view = new AutoLinearLayout(context, attrs);
        }

        if (name.equals(LAYOUT_RELATIVELAYOUT)) {
            view = new AutoRelativeLayout(context, attrs);
        }

        if (view != null) return view;

        return super.onCreateView(name, context, attrs);


    }

    /**
     * 设置title
     *
     * @param title ：title
     */
    protected void setTitleName(String title) {
        title_name.setText(title);
    }

    /**
     * 设置返回
     *
     * @param back        :是否返回：是-->返回，不是则设置其他图标
     * @param resourcesId :图标id,返回时随意设置，不使用
     */
    protected void setTitleBack(final boolean back, int resourcesId) {
        is_title_back = back;
        if (title_back_first || title_back == null) {

            title_back.setOnClickListener(this);
            title_back_first = false;
        }
        title_back.setVisibility(View.VISIBLE);
        if (!back) {
            title_back.setImageResource(resourcesId);
        }
    }

    /**
     * title右侧文字
     *
     * @param str :文字内容
     */
    protected void setTitleRightText(String str) {

        textView.setVisibility(View.VISIBLE);
        textView.setText(str);
        textView.setOnClickListener(this);
    }

    protected abstract void onActivityCreate(Bundle savedInstanceState);

    @Override
    public void setTitle(CharSequence title) {
        if (actionBar != null) actionBar.setTitle(title);
    }

    @Override
    public void setTitle(int titleId) {
        if (actionBar != null) actionBar.setTitle(titleId);
    }

    @Override
    public View findViewById(int id) {
        return rootContent.findViewById(id);
    }

    private void clearContentView() {
        rootContent.removeAllViews();
    }

    @Override
    public void setContentView(int layoutResID) {
        clearContentView();
        getLayoutInflater().inflate(layoutResID, rootContent, true);
    }

    @Override
    public void setContentView(View view) {
        clearContentView();
        rootContent.addView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        clearContentView();
        rootContent.addView(view, params);
    }
}