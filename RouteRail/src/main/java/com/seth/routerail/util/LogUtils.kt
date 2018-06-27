package com.seth.routerail.util

import android.util.Log

/**
 * Created by hspcadmin on 2018/6/6.
 */
object LogUtils{
    val TAG: String = "MyOkHttp"
    var LOG_ENABLE: Boolean = true;

    fun d(msg: String?, tag: String = TAG){
        if (LOG_ENABLE)
            Log.d(tag,msg)
    }
    fun i(msg: String?, tag: String = TAG){
        if (LOG_ENABLE)
            Log.i(tag,msg)
    }
    fun w(msg: String?, tag: String = TAG){
        if (LOG_ENABLE)
            Log.w(tag,msg)
    }
    fun e(msg: String?, tag: String = TAG){
        if (LOG_ENABLE)
            Log.e(tag,msg)
    }
}