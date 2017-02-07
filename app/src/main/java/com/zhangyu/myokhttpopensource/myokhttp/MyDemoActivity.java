package com.zhangyu.myokhttpopensource.myokhttp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.activity.BannerActivity;
import com.zhangyu.myokhttpopensource.myokhttp.activity.ImitationWxActivity;
import com.zhangyu.myokhttpopensource.myokhttp.activity.MainActivity_P2P;
import com.zhangyu.myokhttpopensource.myokhttp.activity.MaterialDesignActivity;
import com.zhangyu.myokhttpopensource.myokhttp.activity.MyToolBarActivity;
import com.zhangyu.myokhttpopensource.myokhttp.activity.ScreenActivity;
import com.zhangyu.myokhttpopensource.myokhttp.util.MD5Utils;
import com.zhangyu.myokhttpopensource.myokhttp.view.MarqueeView;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/1/11.
 */
public class MyDemoActivity extends Activity implements View.OnClickListener {
    //http://vhost119.zihaistar.com/api/index/token
    private String str;
    private Button banner;

    /*
        this.client_id = "20160001";
        this.grant_type = grant_type;
        this.source_from = "1";
        this.add_time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        this.sign_info = (UtilMD5.MD5Encode(grant_type + this.client_id + this.add_time + "24SD%F4}S5", "UTF-8")).toUpperCase();*/

    String md5str;


    Button btn_getrequest;
    public String getAccessToken;

    Button btn_gettoolbar_layout;
    Button btn_get_autolayout;


   private MarqueeView marqueeView;


    private Button btn_get_materialdesign;

    private Button btn_get_jsoncallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydemo);

        btn_getrequest = (Button) findViewById(R.id.btn_getrequest);
        btn_getrequest.setOnClickListener(this);

        banner = (Button) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        btn_gettoolbar_layout = (Button) findViewById(R.id.btn_gettoolbar_layout);
        btn_gettoolbar_layout.setOnClickListener(this);

        btn_get_autolayout = (Button) findViewById(R.id.btn_get_autolayout);
        btn_get_autolayout.setOnClickListener(this);
        btn_get_materialdesign= (Button) findViewById(R.id.btn_get_materialdesign);
        btn_get_materialdesign.setOnClickListener(this);

        btn_get_jsoncallback= (Button) findViewById(R.id.btn_get_jsoncallback);
        btn_get_jsoncallback.setOnClickListener(this);

        str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        md5str = MD5Utils.encode("index/index" + "20160001" + str + "24SD%F4}S5").toUpperCase();

        marqueeView= (MarqueeView) findViewById(R.id.marqueeView);
        List<String> info = new ArrayList<>();
        info.add("1.开源项目okhttpopenresource");
       // info.add("2.开发者：龙采科技张宇");
        info.add("2.开发者：张宇");
        info.add("3. GitHub帐号：yuanchongzhang");
        info.add("4.开源项目地址：https://github.com/yuanchongzhang/MyOkHttpOpenResource");
        info.add("5. 参考网站：http://stackoverflow.com/questions/1016896/get-screen-dimensions-in-pixels/15699681#15699681");
        info.add("6. 欢迎star");
        marqueeView.startWithList(info);
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                position = position + 1;
                Toast.makeText(MyDemoActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void getData() {

        OkGo.get("http://vhost119.zihaistar.com/api/index/token")//
                .tag(this)//
                .params("client_id", "20160001")
                .params("grant_type", "index/index")
                .params("source_from", "1")
                .params("add_time", str)
                .params("sign_info", md5str)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Toast.makeText(MyDemoActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
                        getAccessToken = s;
                        Log.d(getAccessToken, "11111111111");
                        Gson gson = new Gson();
/*
                        AccessToken accessToken = new AccessToken();

                        accessToken = gson.fromJson(s, AccessToken.class);

                        Log.d(accessToken.getAccess_token(), "----------------------------");*/

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_getrequest:
                startActivity(new Intent(MyDemoActivity.this, MainActivity_P2P.class));
                // getData();
                break;

            case R.id.banner:
                startActivity(new Intent(MyDemoActivity.this, BannerActivity.class));

                break;

            case R.id.btn_gettoolbar_layout:
                startActivity(new Intent(MyDemoActivity.this, MyToolBarActivity.class));

                break;

            case R.id.btn_get_autolayout:
                startActivity(new Intent(MyDemoActivity.this, ScreenActivity.class));

                break;

            case R.id.btn_get_materialdesign:

                startActivity(new Intent(MyDemoActivity.this, MaterialDesignActivity.class));
                break;


            case R.id.btn_get_jsoncallback:

               startActivity(new Intent(MyDemoActivity.this, ImitationWxActivity.class));
                break;

        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//反注册EventBus
    }

  /*  @Subscribe
    public void onEventMainThread(FirstEvent event) {

        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Log.d("harvic", msg);
        tv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }*/

    // This method will be called when a MessageEvent is posted (in the UI thread for Toast)
  /*  @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {

        String msg = "onEventMainThread收到了消息：" + event.message;
        Log.d("harvic", msg);
        tv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    //    Toast.makeText(this, event.message, Toast.LENGTH_SHORT).show();
    }*/


}
