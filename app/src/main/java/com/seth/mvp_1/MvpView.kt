package com.seth.mvp_1

/**
 * Created by hspcadmin on 2018/6/14.
 */
interface MvpView{
    /**
     * 显示正在加载进度框
     */
    fun showLoading()

    /**
     * 隐藏正在加载进度框
     */
    fun hideLoading()

    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    fun showData(data: String)

    /**
     * 当数据请求失败后，调用此接口提示
     * @param msg 失败信息
     */
    fun showFailureMessage(msg: String)

    /**
     *当数据请求异常，调用此接口提示
     */
    fun showErrorMessage();
}