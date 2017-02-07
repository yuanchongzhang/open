package com.zhangyu.myokhttpopensource.myokhttp.event;

/**
 * Created by Administrator on 2017/2/7.
 */

public class NewMessageEvent {

    public final String message;

    public NewMessageEvent(String message) {
        this.message = message;
    }
}
