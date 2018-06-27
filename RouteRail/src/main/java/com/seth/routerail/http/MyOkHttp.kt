package com.seth.routerail.http

import android.os.Handler
import android.os.Looper
import com.seth.routerail.http.builder.GetBuilder
import com.seth.routerail.http.builder.PostBuilder
import okhttp3.OkHttpClient

/**
 * Created by hspcadmin on 2018/6/6.
 */
object MyOkHttp{
        val myClient: OkHttpClient = OkHttpClient()
        val myHandle: Handler = Handler(Looper.getMainLooper())

        fun get(): GetBuilder{
            return GetBuilder(this)
        }

        fun post(): PostBuilder{
            return PostBuilder(this)
        }
}