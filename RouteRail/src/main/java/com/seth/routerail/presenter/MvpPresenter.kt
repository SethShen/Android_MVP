package com.seth.routerail.presenter

import com.seth.routerail.`object`.RouteInfo
import com.seth.routerail.view.MvpView
import com.seth.routerail.callback.Callback
import com.seth.routerail.model.RailInfoModel

/**
 * Created by hspcadmin on 2018/6/20.
 */
class MvpPresenter: BasePresenter<MvpView>() {
    /**
     * 获取网络数据
     * @param params 参数
     */
    fun getData(path: String, params: String? = null){
        //显示加载进度条
        getView()?.showLoading()
        //调用Model请求数据
//        DataModel().request(Token.API_MVP_MODEL)?.
//                path(path)?.
//                params(params)?.
//                execute(object : MvpCallback {
//                    override fun onSuccess(data: String) {
//                        //调用view接口显示数据
//                        getView()?.showData(data)
//                    }
//
//                    override fun onFailure(msg: String) {
//                        getView()?.showToast(msg)
//                    }
//
//                    override fun onError() {
//                        getView()?.showError()
//                    }
//
//                    override fun onComplete() {
//                        getView()?.hideLoading()
//                    }
//                } as Callback<Any>)
        RailInfoModel().
                path(path).
                clazz(RouteInfo::class.java).
                execute(object : Callback<ArrayList<RouteInfo>>{
                    override fun onSuccess(datas: ArrayList<RouteInfo>) {
                        getView()?.showList(datas)
                    }

                    override fun onFailure(msg: String) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onError() {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onComplete() {
                        getView()?.hideLoading()
                    }

                })
    }
}


