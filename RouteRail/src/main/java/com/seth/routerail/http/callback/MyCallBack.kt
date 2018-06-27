package com.seth.routerail.http.callback

import com.seth.routerail.http.MyOkHttp
import com.seth.routerail.http.response.IResponseHandle
import com.seth.routerail.util.LogUtils
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException


/**
 * Created by hspcadmin on 2018/6/6.
 */
open class MyCallBack(val mRespondHandle: IResponseHandle) : Callback {
    override fun onFailure(call: Call?, e: IOException?) {
        LogUtils.e("onFailure")
        MyOkHttp.myHandle.post(object : Runnable{
            override fun run() {
                mRespondHandle.onFailure(0,e.toString())
            }
        })
    }
    override fun onResponse(call: Call?, response: Response?) {
        if(response!!.isSuccessful){
            mRespondHandle.onSuccess(response)
        }else{
            LogUtils.e("onResponse fail status=" + response.code())
            MyOkHttp.myHandle.post(object : Runnable{
                override fun run() {
                    mRespondHandle.onFailure(response.code(),"fail status=" + response.code())
                }
            })
        }
    }

}