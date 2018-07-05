package com.seth.routerail.base

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.view.LayoutInflater
import android.view.MenuItem
import com.seth.routerail.R
import com.seth.routerail.util.StatusBarUtils
import kotlinx.android.synthetic.main.activity_drawer_base.*

/**
 * Created by hspcadmin on 2018/7/3.
 */
open class BaseDrawerActivity: BaseActivity() , NavigationView.OnNavigationItemSelectedListener{

    protected var statusBarColor = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_base)
        StatusBarUtils.apply {
            mActivity = this@BaseDrawerActivity
            mColor = statusBarColor
            isDrawerLayout = true
            drawerContentId = R.id.base_drawer_content
            initScreen()
        }
        setDrawerLayout()
    }

    fun addMainContentView(layoutId: Int){
        LayoutInflater.from(this).inflate(layoutId, base_drawer_content ,true)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    private fun setDrawerLayout(){
        val toggle = ActionBarDrawerToggle(
                this, base_drawer_layout, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        base_drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

}