package com.seth.mvp_2.base

import android.content.Context

/**
 * Created by hspcadmin on 2018/6/20.
 */
interface BaseView{
    /**
     * 显示正在加载进度框
     */
    fun showLoading()

    /**
     * 隐藏正在加载进度框
     */
    fun hideLoading()

    /**
     * 显示提示
     */
    public fun showToast(msg: String);

    /**
     *显示请求错误提示
     */
    fun showError();

    /**
     * 获取上下文
     * @return 上下文
     */
    public fun getContext(): Context
}