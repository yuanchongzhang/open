package com.zhangyu.myokhttpopensource.myokhttp.activity;

import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.WindowManager;

import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.fragement.ListFragment;
import com.zhangyu.myokhttpopensource.myokhttp.fragement.RegisterFragment;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;

public class ScreenActivity extends AutoLayoutActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setImmersionStatus();
        setContentView(R.layout.activity_screen);


        initView();
        initDatas();
    }



    private void setImmersionStatus() {
        if (VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
//			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    private void initDatas() {
        ArrayList<Fragment> mList = new ArrayList<Fragment>();
        mList.add(new ListFragment());
        mList.add(new RegisterFragment());
       /* mList.add(new PayFragment());
        mList.add(new RecyclerViewFragment());
        mList.add(new RecyclerViewGridFragment());
        mList.add(new TestFragment());*/
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), mList));
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public class MyAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> tabs = null;

        public MyAdapter(FragmentManager fm, ArrayList<Fragment> tabs) {
            super(fm);
            this.tabs = tabs;
        }

        @Override
        public Fragment getItem(int pos) {
            return tabs.get(pos);
        }

        @Override
        public int getCount() {
            return tabs.size();
        }
    }

}
