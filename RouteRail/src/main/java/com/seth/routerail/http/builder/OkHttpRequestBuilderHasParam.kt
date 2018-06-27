package com.seth.routerail.http.builder

import com.seth.routerail.http.MyOkHttp
import com.seth.routerail.http.callback.MyCallBack
import com.seth.routerail.http.response.IResponseHandle
import com.seth.routerail.util.LogUtils
import okhttp3.Request

/**
 * Created by hspcadmin on 2018/6/7.
 */
abstract class OkHttpRequestBuilderHasParam<T: OkHttpRequestBuilder<T>>(myOkHttp: MyOkHttp) : OkHttpRequestBuilder<T>(myOkHttp){
    var mParams : MutableMap<String, String>? = null
    var errorMsg :String = "Request enqueue error:"

    override fun enqueue(responseHandle: IResponseHandle) {
        try {
            if (mUrl == null || mUrl?.length == 0){
                throw IllegalArgumentException("url can not be null")
            }
            val builder: Request.Builder = equeueBuilder();
            appendHeader(builder,mHarder)
            if(mTag != null){
                builder.tag(mTag)
            }
            val request: Request = builder.build()
            myOkHttp.myClient.newCall(request).enqueue(object : MyCallBack(responseHandle){})
        }catch (e: Exception){
            LogUtils.e(errorMsg+e.message)
        }
    }

    abstract fun equeueBuilder(): Request.Builder

    fun addParam(key: String, value: String): T{
        if(mParams==null){
            mParams = LinkedHashMap()
        }
        mParams?.put(key, value)
        return this as T
    }
}