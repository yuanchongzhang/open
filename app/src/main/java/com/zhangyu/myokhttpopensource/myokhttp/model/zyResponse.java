package com.zhangyu.myokhttpopensource.myokhttp.model;

import java.io.Serializable;

/**
 * ================================================
 * 作    者：（张宇）Github地址：
 * 版    本：1.0
 * 创建日期：16/9/28
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class zyResponse<T> implements Serializable {

    private static final long serialVersionUID = 5213230387175987834L;

    public int list;
    public String page;
    public T data;
}