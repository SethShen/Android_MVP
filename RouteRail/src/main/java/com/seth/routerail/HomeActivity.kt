package com.seth.routerail

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.seth.routerail.`object`.RouteInfo
import com.seth.routerail.adapter.HomeAdapter
import com.seth.routerail.base.BaseDrawerActivity
import com.seth.routerail.presenter.MvpPresenter
import com.seth.routerail.view.MvpView
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by hspcadmin on 2018/7/5.
 */
class HomeActivity : BaseDrawerActivity(), MvpView {


    private var presenter: MvpPresenter? = null
    private lateinit var adapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        isDrawerLayout = false                      //设置是否有侧边栏
        statusBarColor = resources.getColor(R.color.color_bg)//设置状态栏颜色
        super.onCreate(savedInstanceState)
        addMainContentView(R.layout.activity_home)


       // var transation = this.supportFragmentManager.beginTransaction()
       // transation.add(R.id.home_top_content_fl, RouteCitiesFragment()).commit()
        var linearLayoutManager = LinearLayoutManager(this)
        home_content_recylcerview.layoutManager = linearLayoutManager
        var adapter = HomeAdapter()
        presenter = MvpPresenter().apply {
            attachView(this@HomeActivity)
        }
    }

    override fun showList(datas: ArrayList<RouteInfo>) {
        adapter.
    }

    override fun showData(data: String) {
        //text.text = data
    }
    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
    }

}
