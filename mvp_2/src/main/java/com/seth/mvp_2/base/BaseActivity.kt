package com.seth.mvp_2.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.Toast
import com.seth.mvp_2.util.ProgressFragmentDialog

/**
 * Created by hspcadmin on 2018/6/20.
 */
abstract class BaseActivity: AppCompatActivity(), BaseView{
    private var progressDialog: ProgressFragmentDialog? = null
    private val transcation = supportFragmentManager.beginTransaction() as FragmentTransaction


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        this.window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)  //加载期间不可点击
//        this.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)   //取消不可点击设置
    }

    /**
     * 显示加载圈
     */
    override fun showLoading() {
        if(!progressDialog?.isAdded){
            progressDialog?.show(transcation, "SHOW_PROGRESS_DIALOG")
        } else if(!progressDialog.dialog.isShowing){
            progressDialog.dialog.show()
        }
    }

    /**
     * 隐藏加载圈
     */
    override fun hideLoading() {
        if(progressDialog.isAdded && progressDialog.dialog.isShowing){
            progressDialog.dialog.dismiss()
        }
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showError() {
        showToast("出现了不可知错误")
    }

    override fun getContext(): Context {
        return this@BaseActivity
    }
}