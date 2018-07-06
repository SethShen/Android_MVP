package com.seth.routerail.model

import com.seth.routerail.callback.Callback

/**
 * Created by seth on 2018/6/25.
 */
public abstract class BaseModel<T>(vararg args: String){

    //数据请求参数
    protected var mParams: Array<out String>? = null
    protected var mPath: String? = null
    protected var clazz: Class<*>? = null
    /**
     * 设置数据请求参数
     *
     */
    constructor() : this(args = *emptyArray<String>())

    init {
        mParams = args
    }
    fun params(vararg args: String): BaseModel<Any> {
        mParams = args
        return this as BaseModel<Any>
    }

    fun path(path: String?): BaseModel<Any>{
        mPath = path
        return this as BaseModel<Any>
    }

    fun clazz(clazz: Class<*>): BaseModel<Any>{
        this.clazz = clazz
        return this as BaseModel<Any>
    }

    //添加Callback并执行数据请求
    //具体的数据请求由子类实现
    abstract fun execute(callback: T)

    //执行Get网络请求
    fun requesrGetAPI(url: String, callback: T){

    }

    //执行Get网络请求
    fun requesrGetAPI(url: String, params: Map<String, String>, callback: T){

    }


}
