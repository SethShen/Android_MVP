package com.seth.mvp_2

/**
 * Created by hspcadmin on 2018/6/20.
 */
interface MvpCallback{
    /**
     * 数据请求成功
     * @param data 请求到的数据
     */
    fun onSuccess(data: String)

    /**
     * 使用网络API接口请求方式是，虽然已经请求成功但是
     * 由于{@code msg}的原因无法正常返回数据
     */
    fun onFailure(msg: String)

    /**
     * 请求数据失败，指在请求网络API接口请求方式时，出项无法联网、
     * 缺少权限，内存泄露等原因导致无法连接到请求数据源
     */
    fun onError()

    /**
     * 当请求数据结束是，无论结果是成功，失败或是抛出异常都会执行此方法
     * 给用户作处理，通常用作网络请求完成时隐藏“正在加载”的等待控件
     */
    fun onComplete()
}