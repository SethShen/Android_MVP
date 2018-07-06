package com.seth.routerail.model

import com.seth.routerail.callback.Callback
import com.seth.routerail.http.MyOkHttp
import com.seth.routerail.http.response.JsonResponseHandler

/**
 * Created by hspcadmin on 2018/7/6.
 */
class RailInfoModel(vararg args: String) : BaseModel<Callback<Any>>(*args){

    override fun execute(callback: Callback<Any>) {
        MyOkHttp.get().apply {
            mUrl = this@RailInfoModel.mPath
        }.enqueue(object : JsonResponseHandler(clazz!!){
            override fun onFailure(statusCode: Int, error_msg: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onSuccess(statusCode: Int, obj: Any?) {
                callback.onSuccess(obj!!)
                callback.onComplete()
            }

        })
    }

}