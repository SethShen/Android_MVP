package com.seth.routerail.http.builder

import com.seth.routerail.http.MyOkHttp
import okhttp3.FormBody
import okhttp3.MediaType
import okhttp3.Request
import okhttp3.RequestBody

/**
 * Created by hspcadmin on 2018/6/8.
 */
class PostBuilder(myOkHttp: MyOkHttp): OkHttpRequestBuilderHasParam<PostBuilder>(myOkHttp){
    private var mJsonParams: String = ""

    override fun equeueBuilder(): Request.Builder {
        errorMsg = "Post enqueue error:"
        var builder = Request.Builder().url(mUrl)
        if(mJsonParams.length > 0){
            var body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), mJsonParams)
            builder.post(body)
        }else{
            var encodingBuilder = FormBody.Builder()
            appendParams(encodingBuilder, mParams)
            builder.post(encodingBuilder.build())
        }
        return builder
    }

    private fun appendParams(builder: FormBody.Builder, params: MutableMap<String, String>?) {
        if(params != null && params.isEmpty()){
            for (key in params.keys){
                builder.add(key,params.get(key))
            }
        }
    }
}