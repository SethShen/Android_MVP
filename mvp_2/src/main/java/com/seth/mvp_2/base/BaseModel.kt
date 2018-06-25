package com.seth.mvp_2.base

/**
 * Created by seth on 2018/6/25.
 */
public abstract class BaseModel<T>(vararg args: String){

    //数据请求参数
    protected var mParams: Array<out String>? = null

    /**
     * 设置数据请求参数
     *
     */
//    constructor(vararg args: String) : this(){
//        this.mParams = args
//    }
    init {
        mParams = args
    }

    //添加Callback并执行数据请求
    //具体的数据请求由子类实现
    public abstract fun execute(callback: Callback<T>)

    //执行Get网络请求
    protected fun requesrGetAPI(url: String, callback: Callback<T>){

    }

    //执行Get网络请求
    protected fun requesrGetAPI(url: String, params: Map<String, String>, callback: Callback<T>){

    }


}
