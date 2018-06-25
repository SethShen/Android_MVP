package com.seth.mvp_2

import com.seth.mvp_2.base.BasePresenter

/**
 * Created by hspcadmin on 2018/6/20.
 */
class MvpPresenter: BasePresenter<MvpView>() {

    /**
     * 获取网络数据
     * @param params 参数
     */
    public fun getData(params: String){
        //显示加载进度条
        getView()?.showLoading()
        //调用Model请求数据
        MvpModel(params).execute(object : MvpCallback{
            override fun onSuccess(data: String) {
                //调用view接口显示数据
                getView()?.showData(data)
            }

            override fun onFailure(msg: String) {
                getView()?.showToast(msg)
            }

            override fun onError() {
                getView()?.showError()
            }

            override fun onComplete() {
                getView()?.hideLoading()
            }
        })
        MvpModel.getNetData(params,object : MvpCallback{
            override fun onSuccess(data: String) {
                //调用view接口显示数据
                getView()?.showData(data)
            }

            override fun onFailure(msg: String) {
                getView()?.showToast(msg)
            }

            override fun onError() {
                getView()?.showError()
            }

            override fun onComplete() {
                getView()?.hideLoading()
            }
        })
    }

}


