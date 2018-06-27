package com.seth.routerail.util

import android.content.Context
import android.content.SharedPreferences
import com.seth.routerail.base.BaseApplication
import java.util.*

/**
 * Created by hspcadmin on 2018/6/27.
 */
object SharePreferencesHelper{
    val STRING = 0
    val INT = 1
    val BOOLEAN =2
    val FLOAT = 3
    val ANY = -1
    val BITMAP = 4

//    fun WriteSharePreferences(dataBaseName: String, map: TreeMap){
//
//    }

    fun setSharedPreferences(dataBaseName: String, key: String, value: Any){
        if(key == null || value == null ){
            return;
        }
        val preferences = BaseApplication.application.getSharedPreferences(dataBaseName, Context.MODE_PRIVATE);
        var editor = preferences.edit()
        if(value is Int){
        }
    }
}