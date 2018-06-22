package com.seth.mvp_1

/**
 * Created by hspcadmin on 2018/6/14.
 */
class MvpPresenter(val mView: MvpView){
    public fun getData(params: String){
        //显示加载进度条
        mView.showLoading()
        //调用Model请求数据
        MvpModel.getNetData(params,object : MvpCallback{
            override fun onSuccess(data: String) {
                //调用view接口显示数据
                mView.showData(data)
            }

            override fun onFailure(msg: String) {
                mView.showFailureMessage(msg)
            }

            override fun onError() {
                mView.showErrorMessage()
            }

            override fun onComplete() {
                mView.hideLoading()
            }
        })
    }

}