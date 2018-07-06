package com.seth.routerail.model

import com.seth.routerail.callback.Callback
import com.seth.routerail.http.MyOkHttp
import com.seth.routerail.http.response.JsonResponseHandler
import com.seth.routerail.util.LogUtils

/**
 * Created by hspcadmin on 2018/7/6.
 */
class RailInfoModel(vararg args: String) : BaseModel<Callback<Any>>(*args){

    override fun execute(callback: Callback<Any>) {
        MyOkHttp.get().apply {
            mUrl = this@RailInfoModel.mPath
            mTag = this@RailInfoModel
        }.enqueue(object : JsonResponseHandler(clazz!!){
            override fun onFailure(statusCode: Int, error_msg: String) {
                LogUtils.e("onResponse fail parse jsonobject, body="+error_msg)
            }

            override fun onSuccess(statusCode: Int, obj: Any?) {
                callback.onSuccess(obj!!)
                callback.onComplete()
            }

        })
    }

}