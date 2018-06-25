package com.seth.mvp_2.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import com.seth.mvp_2.R
import com.seth.mvp_2.util.ProgressFragmentDialog
import kotlinx.android.synthetic.main.activity_base.*

/**
 * Created by hspcadmin on 2018/6/20.
 */
abstract class BaseActivity: AppCompatActivity(), BaseView{
    private var progressDialog: ProgressFragmentDialog? = null
    private val transcation = supportFragmentManager.beginTransaction() as FragmentTransaction
    private var parentFramLayout: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initContentView(R.layout.activity_base)
    }

    private fun initContentView(layoutResID: Int) {
        var group = findViewById<ViewGroup>(android.R.id.content)       //获取窗口的根布局
        group.removeAllViews()                                          //移除根布局上的组件
        parentFramLayout = FrameLayout(this)
        group.addView(parentFramLayout)                               //将自定义父布局，加载到窗口的根布局上
        LayoutInflater.from(this).inflate(layoutResID, parentFramLayout ,true)  //将自定义字布局加入到parentFragment上
    }

    override fun setContentView(layoutResID: Int) {
        LayoutInflater.from(this).inflate(layoutResID, parentFramLayout, true)
    }

    override fun setContentView(view: View?) {
        parentFramLayout?.addView(view)
    }

    /**
     * 显示加载圈
     */
    override fun showLoading() {
        base_progressbar.visibility = View.VISIBLE
    }

    /**
     * 隐藏加载圈
     */
    override fun hideLoading() {
        base_progressbar.visibility = View.GONE
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