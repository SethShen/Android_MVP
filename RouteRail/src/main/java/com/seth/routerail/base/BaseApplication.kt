package com.seth.routerail.base

import android.app.Application

/**
 * Created by hspcadmin on 2018/6/27.
 */
class BaseApplication : Application(){
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

    }

    public fun getData(key: String, type: Int, dataBaseName: String = "Cache"): Any?{

        return null;
    }

    public fun resetData(key: String, dataBaseName: String = "Cache"){

    }


}