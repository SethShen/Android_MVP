package com.seth.mvp_2

import android.os.Handler
import com.seth.mvp_2.base.BaseModel
import com.seth.mvp_2.base.Callback

/**
 * Created by hspcadmin on 2018/6/20.
 */
class MvpModel(vararg args: String) : BaseModel<String>(*args) {

    /**
     *获取网络请求数据
     * @param param 请求参数
     * @param callback 数据回调接口
     */
    override fun execute(callback: Callback<String>) {
        Handler().postDelayed(object : Runnable{
            override fun run() {
                when(mParams?.let { it[0] }){
                    "normal"->callback.onSuccess("根据参数"+ mParams?.let { it[0] }+"的请求网络数据成功")
                    "failure"->callback.onFailure("请求失败：参数有误")
                    "error"->callback.onError();
                }
                callback.onComplete()
            }
        },1000)
    }

//    public fun getNetData(param: String, callback: MvpCallback){
//        Handler().postDelayed(object : Runnable{
//            override fun run() {
//                when(param){
//                    "normal"->callback.onSuccess("根据参数"+param+"的请求网络数据成功")
//                    "failure"->callback.onFailure("请求失败：参数有误")
//                    "error"->callback.onError();
//                }
//                callback.onComplete()
//            }
//        },1000)
//    }
}