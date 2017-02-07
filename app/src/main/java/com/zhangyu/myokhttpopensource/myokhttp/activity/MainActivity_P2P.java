package com.zhangyu.myokhttpopensource.myokhttp.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.adapter.FragPagerAdapter;
import com.zhangyu.myokhttpopensource.myokhttp.event.NewMessageEvent;
import com.zhangyu.myokhttpopensource.myokhttp.fragement.FifthFragment;
import com.zhangyu.myokhttpopensource.myokhttp.fragement.FirstFragment;
import com.zhangyu.myokhttpopensource.myokhttp.fragement.FourthFragment;
import com.zhangyu.myokhttpopensource.myokhttp.fragement.SecondFragment;
import com.zhangyu.myokhttpopensource.myokhttp.fragement.ThirdFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;


/**
 * Created by Administrator on 2017/1/12.
 */
public class MainActivity_P2P extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    /**
     * 主页viewpager的adapter
     */
    private FragPagerAdapter pagerAdapter;
    /**
     * 保存fragment的list
     */
    private ArrayList<Fragment> fragments;
    /**
     * fragment管理类
     */
    private FragmentManager fragmentManager;


    public Boolean FLAG = Boolean.TRUE;

    @Bind(R.id.iv_main_tab_01)
    ImageView ivMainTab01;
    @Bind(R.id.tv_main_tab_01)
    TextView tvMainTab01;
    @Bind(R.id.ll_main_tab_01)
    LinearLayout llMainTab01;
    @Bind(R.id.iv_main_tab_02)
    ImageView ivMainTab02;
    @Bind(R.id.tv_main_tab_02)
    TextView tvMainTab02;
    @Bind(R.id.ll_main_tab_02)
    LinearLayout llMainTab02;
    @Bind(R.id.iv_main_tab_03)
    ImageView ivMainTab03;
    @Bind(R.id.tv_main_tab_03)
    TextView tvMainTab03;
    @Bind(R.id.ll_main_tab_03)
    LinearLayout llMainTab03;
    @Bind(R.id.iv_main_tab_04)
    ImageView ivMainTab04;
    @Bind(R.id.tv_main_tab_04)
    TextView tvMainTab04;
    @Bind(R.id.ll_main_tab_04)
    LinearLayout llMainTab04;
    @Bind(R.id.iv_main_tab_05)
    ImageView ivMainTab05;
    @Bind(R.id.tv_main_tab_05)
    TextView tvMainTab05;
    @Bind(R.id.ll_main_tab_05)
    LinearLayout llMainTab05;
    @Bind(R.id.vp_main)
    ViewPager vpMain;
    SecondFragment secondFragment;
    private String str_getFirstData;
    public static final int LOGOUT = 0;//退出
    public static final int LOGOUT2 = 1;//退出

    String accesstoken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_p2p);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);

        initView();
        initListener();
    }

    private void initView() {
        FirstFragment firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        ThirdFragment thirdFragment = new ThirdFragment();
        FourthFragment fourthFragment = new FourthFragment();
        FifthFragment fifthFragment = new FifthFragment();
        fragments = new ArrayList<>();
        fragments.add(firstFragment);
        fragments.add(secondFragment);
        fragments.add(thirdFragment);
        fragments.add(fourthFragment);
        fragments.add(fifthFragment);
        fragmentManager = this.getSupportFragmentManager();
        pagerAdapter = new FragPagerAdapter(fragmentManager, fragments);
        vpMain.setAdapter(pagerAdapter);
        vpMain.setOffscreenPageLimit(0);
        ivMainTab01.setSelected(true);
        tvMainTab01.setSelected(true);


    }

    private void initListener() {
        llMainTab01.setOnClickListener(this);
        llMainTab02.setOnClickListener(this);
        llMainTab03.setOnClickListener(this);
        llMainTab04.setOnClickListener(this);
        llMainTab05.setOnClickListener(this);
        vpMain.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_main_tab_01:
                vpMain.setCurrentItem(0);
                break;
            case R.id.ll_main_tab_02:
                vpMain.setCurrentItem(1);
                break;
            case R.id.ll_main_tab_03:
                vpMain.setCurrentItem(2);
                break;
            case R.id.ll_main_tab_04:
                vpMain.setCurrentItem(3);
                break;
            case R.id.ll_main_tab_05:
                vpMain.setCurrentItem(4);
                break;
        }
    }

    private void initFirstView() {
        ivMainTab01.setSelected(true);
        tvMainTab01.setSelected(true);
    }

    private void initSecondView() {
        ivMainTab02.setSelected(true);
        tvMainTab02.setSelected(true);
    }

    private void initThirdView() {
        ivMainTab03.setSelected(true);
        tvMainTab03.setSelected(true);
    }

    private void initFourthView() {
        ivMainTab04.setSelected(true);
        tvMainTab04.setSelected(true);
    }

    private void initFifthView() {
        ivMainTab05.setSelected(true);
        tvMainTab05.setSelected(true);
    }

    private void initTab() {
        ivMainTab01.setSelected(false);
        tvMainTab01.setSelected(false);
        ivMainTab02.setSelected(false);
        tvMainTab02.setSelected(false);
        ivMainTab03.setSelected(false);
        tvMainTab03.setSelected(false);
        ivMainTab04.setSelected(false);
        tvMainTab04.setSelected(false);
        ivMainTab05.setSelected(false);
        tvMainTab05.setSelected(false);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        initTab();
        switch (position) {
            case 0:
                initFirstView();
                break;
            case 1:
                initSecondView();
                break;
            case 2:
                initThirdView();
                break;
            case 3:
                initFourthView();
                break;
            case 4:
                initFifthView();
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }


    public void setSelect(int position) {
        vpMain.setCurrentItem(position);
    }

    public void setFirstSelect(boolean isFirst) {
        FLAG = isFirst;
    }

    public boolean getFirstSelect() {
        return FLAG;
    }


    /**
     * 这里用到的了EventBus框架
     *
     * @param
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(NewMessageEvent event) {
        String msg = "onEventMainThread收到了消息：" + event.message;
        Log.d("harvic", msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        if (event.message.equals("1")){
            vpMain.setCurrentItem(1);
        }else {
            vpMain.setCurrentItem(2);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//反注册EventBus
    }

}
