package com.zhangyu.myokhttpopensource.myokhttp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.event.NewMessageEventCallBack;

import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 2017/2/6.
 */

public class ResultActivity extends Activity {

    private Button btn_FirstEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn_FirstEvent = (Button) findViewById(R.id.btn_first_event);

        btn_FirstEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                /*EventBus.getDefault().post(
                        new NewMessageEventCallBack("返回值传递过来了"));*/
                EventBus.getDefault().post(new NewMessageEventCallBack("返回值传递过来了"));
              //  finish();

/*
                Intent intent = new Intent();
                intent.putExtra("message","返回值传递过来了");
                setResult(100,intent);*/

                //  MainActivity.OnCityChangeCallBack.onCityChange2(message);

                finish();

            }
        });
    }
}

