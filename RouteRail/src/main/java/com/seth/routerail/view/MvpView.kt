package com.seth.routerail.view

import com.seth.routerail.`object`.RouteInfo
import com.seth.routerail.view.BaseView

/**
 * Created by hspcadmin on 2018/6/20.
 */
interface MvpView: BaseView {
    fun showData(data: String)
    fun showList(datas: ArrayList<RouteInfo>) {}
}