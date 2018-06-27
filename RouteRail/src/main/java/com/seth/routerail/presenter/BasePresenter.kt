package com.seth.routerail.presenter

import com.seth.routerail.view.BaseView

/**
 * Created by hspcadmin on 2018/6/20.
 */
open class BasePresenter<V: BaseView>{
    /**
     * 绑定的view
     */
    private var mvpView: V? = null

    /**
     * 绑定view,一般在初始化中调用该方法
     */
    public fun attachView(mvpView: V){
        this.mvpView = mvpView
    }

    /**
     * 断开view，一般在onDestory中调用
     */
    public fun detachView(){
        this.mvpView = null
    }

    /**
     * 获取连接的view
     */
    public fun getView(): V?{
        return mvpView
    }
}