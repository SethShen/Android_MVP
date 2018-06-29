package com.seth.routerail.base

import android.app.Application
import com.seth.routerail.util.SharePreferencesHelper

/**
 * Created by hspcadmin on 2018/6/27.
 */
open class BaseApplication : Application(){
    companion object {
        lateinit var application: BaseApplication
    }

    override fun onCreate() {
        application = this
        super.onCreate()
    }

    /**
     * 数据储存到本地数据库
     */
    public fun setData(key: String, value: Any, dataBaseName: String = "Cache"){
        SharePreferencesHelper.setSharedPreferences(dataBaseName, key, value)
    }

    public fun getData(key: String, type: Int, dataBaseName: String = "Cache"): Any?{
        return SharePreferencesHelper.getSharedPreferences(dataBaseName, key, type)

    }

    public fun resetData(key: String?, dataBaseName: String = "Cache"){
        key?.let{
            SharePreferencesHelper.removeSharedPreferences(dataBaseName, key)
        }?: SharePreferencesHelper.ClearSharedPreferences(dataBaseName)
    }
}