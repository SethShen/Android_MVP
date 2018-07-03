package com.seth.routerail.util

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager

/**
 * Created by seth on 2018/7/3.
 */
class StatusBarUtils(val mActivity: Activity,  var mColor: Int = -1){

    fun initScreen(){
        fullScreen(mActivity)
        if(mColor != -1){
            addStatusViewWithColor(mActivity, mColor)
        }
    }

    private fun addStatusViewWithColor(activity: Activity, color: Int) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            var rootView = activity.window.decorView.findViewById<ViewGroup>(android.R.id.content)
            rootView.setPadding(0, getStatusBarHeight(activity),0, 0)
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                activity.window.statusBarColor = color
            }else{
                var decorView = activity.window.decorView as ViewGroup
                var statusBarView = View(activity)
                var lp = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity))
                statusBarView.setBackgroundColor(color)
                decorView.addView(statusBarView, lp)
            }

        }
    }

    private fun fullScreen(activity: Activity) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                //5.x需要把颜色设置透明,否则导航栏会呈现系统默认的浅灰色
                var window = activity.window
                var decorView = window.decorView

                var option = View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                decorView.systemUiVisibility = option
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = Color.TRANSPARENT
            }else{
                var window = activity.window
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            }
        }
    }


    public fun getStatusBarHeight(activity: Activity): Int{
        var result = 0;
        //获取状态蓝高度的资源id
        var resourceId = activity.resources.getIdentifier("status_bar_height", "dimen", "android")
        if(resourceId > 0){
            result = activity.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }
}