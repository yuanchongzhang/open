package com.zhangyu.myokhttpopensource.myokhttp.fragement;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.activity.ResultActivity;
import com.zhangyu.myokhttpopensource.myokhttp.event.NewMessageEvent;
import com.zhangyu.myokhttpopensource.myokhttp.event.NewMessageEventCallBack;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import de.greenrobot.event.EventBus;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

    private Button btn_jumpsecond;

    private Button btn_jumpThird;

    private Button btn_jumpResult;

    private TextView btn_jumptext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, null);
        btn_jumpsecond = (Button) view.findViewById(R.id.btn_jumpsecond);
        btn_jumpThird = (Button) view.findViewById(R.id.btn_jumpThird);
        btn_jumpResult = (Button) view.findViewById(R.id.btn_jumpResult);
        btn_jumptext = (TextView) view.findViewById(R.id.btn_jumptext);
        initListener();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    public void initListener() {
        btn_jumpsecond.setOnClickListener(this);
        btn_jumpThird.setOnClickListener(this);
        btn_jumpResult.setOnClickListener(this);
        btn_jumptext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_jumpsecond:
                EventBus.getDefault().post(
                        new NewMessageEvent("1"));
                break;
            case R.id.btn_jumpThird:
                EventBus.getDefault().post(
                        new NewMessageEvent("2"));
                break;

            case R.id.btn_jumpResult:
                startActivity(new Intent(getActivity(), ResultActivity.class));
               /* Intent intent = new Intent(getActivity(), ResultActivity.class);

                startActivityForResult(intent, 100);*/
//              startActivityForResult(new Intent(getActivity(),ResultActivity.class));

                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == requestCode) {
            String dispaly = data.getStringExtra("message");
            btn_jumptext.setText(dispaly);
        } else {
            Toast.makeText(getActivity(), "Request code wrong", Toast.LENGTH_SHORT).show();
        }
        String value = String.valueOf(resultCode);
    }

    /*
    @Override
    //dispaly the message received from intent
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String value = String.valueOf(resultCode);
        String dispaly = data.getStringExtra("message");
        Log.e(TAG, value);

        if (resultCode == mRequest_code) {
            mSetText.setText(dispaly);

        } else {
            Toast.makeText(MainActivity.this, "Request code wrong", Toast.LENGTH_SHORT).show();
        }

    }*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(NewMessageEventCallBack event) {
        String msg = "onEventMainThread收到了消息：" + event.message;
        Log.d("harvic", msg);
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        btn_jumptext.setText(msg);

    }
}
