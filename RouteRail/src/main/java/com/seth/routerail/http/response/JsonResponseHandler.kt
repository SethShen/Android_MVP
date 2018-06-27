package com.seth.routerail.http.response

import com.google.gson.Gson
import com.seth.routerail.http.MyOkHttp
import com.seth.routerail.util.LogUtils
import okhttp3.Response
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONTokener
import java.io.IOException

/**
 * Created by hspcadmin on 2018/6/7.
 */
abstract class JsonResponseHandler(val clazz: Class<*>) : IResponseHandle{
    override fun onSuccess(response: Response) {
        val responseBody: ResponseBody? = response?.body()
        var responseBodyStr: String? = ""
        try {
            responseBodyStr = responseBody?.string();
        }catch (e :IOException){
            e.printStackTrace()
            LogUtils.e("onResponse fail read response body")
            MyOkHttp.myHandle.post(object : Runnable{
                override fun run() {
                    onFailure(response.code(), "fail read response body")
                }
            })
            return
        }finally {
            responseBody?.close()
        }

        try {
            val result: Object  = JSONTokener(responseBodyStr).nextValue() as Object
            if(result is JSONObject){
                val gson = Gson()
                val obj = gson.fromJson(result.toString(),clazz)
                MyOkHttp.myHandle.post(object : Runnable{
                    override fun run() {
                        onSuccess(response.code(), obj)
                    }
                })
            }else if(result is JSONArray){
                val gson = Gson()
                val datas = arrayListOf<Any>()
                for (index: Int in 0..result.length()-1){
                    val item = result.get(index)
                    datas.add(gson.fromJson(item.toString(),clazz))
                }
                MyOkHttp.myHandle.post(object : Runnable{
                    override fun run() {
                        onSuccess(response.code(), datas)
                    }
                })
            }else{
                LogUtils.e("onResponse fail parse jsonobject, body="+responseBodyStr)
                MyOkHttp.myHandle.post(object : Runnable{
                    override fun run() {
                        onFailure(response.code(), "fail parse jsonobject, body="+responseBodyStr)
                    }
                })
            }
        }catch (e: JSONException){
            e.printStackTrace();
            LogUtils.e("onResponse fail parse jsonobject, body="+responseBodyStr)
            MyOkHttp.myHandle.post(object : Runnable{
                override fun run() {
                    onFailure(response.code(),"fail parse jsonobject, body="+responseBodyStr)
                }
            })
        }
    }

    open fun onSuccess(statusCode: Int, obj: Any?) {
        LogUtils.w("onSuccess(int status, obj: Any?)was not overriden, but callback was received")
    }


    open fun onSuccess(statusCode: Int, response: JSONObject){
        LogUtils.w("onSuccess(int status, JSONObject response)was not overriden, but callback was received")
    }
    open fun onSuccess(statusCode: Int, response: JSONArray){
        LogUtils.w("onSuccess(int status, JSONArray response)was not overriden, but callback was received")
    }

    override fun onProgress(currentBytes: Long, totalBytes: Long) {}


}
