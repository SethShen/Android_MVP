package com.seth.routerail.http.builder

import com.seth.routerail.http.MyOkHttp
import com.seth.routerail.http.response.IResponseHandle
import okhttp3.Headers
import okhttp3.Request

/**
 * Created by hspcadmin on 2018/6/6.
 */
abstract class OkHttpRequestBuilder<T: OkHttpRequestBuilder<T>> (val myOkHttp: MyOkHttp){
    var mUrl: String? = null
    var mTag: Any? = null
    var mHarder: MutableMap<String, String>? = null

    abstract fun enqueue(responseHandle: IResponseHandle)

    protected fun appendHeader(builder: Request.Builder?, headers: MutableMap<String, String>?) {
        val headBulider: Headers.Builder = Headers.Builder()
        if (headers != null && headers.keys != null) {
            for (key: String in headers?.keys) {
                headBulider.add(key, headers.get(key))
            }
        }
        builder?.headers(headBulider.build())
    }

}