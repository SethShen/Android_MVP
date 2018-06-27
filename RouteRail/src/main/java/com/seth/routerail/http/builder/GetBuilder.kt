package com.seth.routerail.http.builder

import com.seth.routerail.http.MyOkHttp
import okhttp3.Request


/**
 * Created by hspcadmin on 2018/6/6.
 */
class GetBuilder(myOkhttp: MyOkHttp) : OkHttpRequestBuilderHasParam<GetBuilder>(myOkhttp) {
//    override fun enqueue(responseHandle: IResponseHandle) {
//        try {
//            if (mUrl == null || mUrl?.length == 0){
//                throw IllegalArgumentException("url can not be null")
//            }
//            if (mParams != null && mParams?.size!! > 0)
//                mUrl = appendParams(mUrl, mParams)
//            val builder: Request.Builder = Request.Builder().url(mUrl).get();
//            appendHeader(builder,mHarder)
//            if(mTag != null){
//                builder.tag(mTag)
//            }
//            val request: Request = builder.build()
//            myOkHttp.myClient.newCall(request).enqueue(object : MyCallBack(responseHandle){})
//        }catch (e: Exception){
//            LogUtils.e("Get enqueue error:"+e.message)
//        }
//    }

    override fun equeueBuilder(): Request.Builder {
        errorMsg = "Get enqueue error:"
        if (mParams != null && mParams?.size!! > 0)
            mUrl = appendParams(mUrl, mParams)
        val builder: Request.Builder = Request.Builder().url(mUrl).get();
        return  builder
    }

    private fun appendParams(url: String?, params: MutableMap<String, String>?): String? {
        var stringBuild : StringBuilder = StringBuilder()
        stringBuild.append(url+"?")
        if (params?.keys!=null&&params?.keys.isNotEmpty()) {
            for (key: String in params?.keys)
                stringBuild.append(key).append("=").append(params.get(key)).append("&")
        }
        stringBuild = stringBuild.deleteCharAt(stringBuild.length-1);
        return stringBuild.toString()
    }
}