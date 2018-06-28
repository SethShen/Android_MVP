package com.seth.routerail.util

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import com.seth.routerail.base.BaseApplication
import java.io.*

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

    fun setSharedPreferences(dataBaseName: String, key: String, value: Any){
        if(key == null || value == null ){
            return;
        }
        val preferences = BaseApplication.application.getSharedPreferences(dataBaseName, Context.MODE_PRIVATE);
        var editor = preferences.edit()
        if(value is Int){
            editor.putInt(key, value.toString().toInt())
        }else if(value is Long){
            editor.putLong(key,value.toString().toLong())
        }else if(value is Boolean){
            editor.putBoolean(key,value.toString().toBoolean())
        }else if(value is String){
            editor.putString(key, value.toString())
        }else if(value is Float){
            editor.putFloat(key, value.toString().toFloat())
        }else{
            var baos = ByteArrayOutputStream()
            try{
                var oos = ObjectOutputStream(baos);
                oos.writeObject(value);
                var oAuth_Base64 = String(Base64.encode(baos.toByteArray(), Base64.DEFAULT))
                editor.putString(key, oAuth_Base64)
            }catch (e: IOException){
                e.printStackTrace()
            }finally {
                try {
                    baos.close()
                }catch (e: IOException){
                    e.printStackTrace()
                }
            }
        }
        editor.apply()
    }

    fun setBitmapToSharedPreferences(dataBaseName: String, key: String, bitmap: Bitmap){
        if(key == null || bitmap == null){
            return
        }
        var preferences = BaseApplication.application.getSharedPreferences(dataBaseName, Context.MODE_PRIVATE)
        var editor = preferences.edit();
        var byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream)
        //第二步:利用Base64将字节数组输出流中的数据转换成字符串String
        var byteArray = byteArrayOutputStream.toByteArray();
        var imageString =Base64.encodeToString(byteArray, Base64.DEFAULT).toString()
        //第三步:将String保持至SharedPreferences
        editor.putString(key, imageString)
        editor.apply()
    }
    fun getSharedPreferences(dataBaseName: String, key: String, type: Int): Any?{
        var user = BaseApplication.application.getSharedPreferences(dataBaseName, 0)
        var value :Any? = null
        when(type){
            STRING -> value = user.getString(key, "")
            INT -> value = user.getInt(key, 0)
            BOOLEAN -> value = user.getBoolean(key, false)
            FLOAT -> value = user.getFloat(key, 0f)
            ANY -> value = readObject(dataBaseName, key)
            BITMAP -> value = readBitmap(dataBaseName, key)
        }
        return value
    }

    fun readObject(data: String, key: String): Any?{
        var preferences = BaseApplication.application.getSharedPreferences(data, Context.MODE_PRIVATE)
        return readObject(preferences, key)
    }

    fun readObject(preferences: SharedPreferences, key: String): Any?{
        var value: Any? = null
        var string = preferences.getString(key,"")
        if(string.length<1){
            return null
        }
        var base64 = Base64.decode(string.toByteArray(), Base64.DEFAULT)
        var bais = ByteArrayInputStream(base64)
        try {
            var bis = ObjectInputStream(bais)
            value = bis.readObject()
        }catch (e: Exception){
            e.printStackTrace()
        }

        return value
    }

    fun readBitmap(data: String, key: String): Bitmap{
        var preferences = BaseApplication.application.getSharedPreferences(data, Context.MODE_PRIVATE)
        return readBitmap(preferences, key)
    }

    fun readBitmap(preferences: SharedPreferences, key: String) : Bitmap{
        //第一步:取出字符串形式的Bitmap
        var imageString = preferences.getString(key, "")
        //第二步:利用Base64将字符串转换为ByteArrayInputStream
        var byteArray = Base64.decode(imageString, Base64.DEFAULT)
        var byteArrayInputStream = ByteArrayInputStream(byteArray)
        //第三步:利用ByteArrayInputStream生成Bitmap
        var bitmap = BitmapFactory.decodeStream(byteArrayInputStream)
        return bitmap
    }

    fun ClearSharedPreferences(dataBaseName: String){
        var user = BaseApplication.application.getSharedPreferences(dataBaseName, 0)
        var editor = user.edit()
        editor.clear()
        editor.apply()
    }

    fun removeSharedPreferences(dataBaseName: String, key: String){
        var user = BaseApplication.application.getSharedPreferences(dataBaseName, 0)
        var editor = user.edit()
        editor.remove(key)
        editor.apply()
    }

}