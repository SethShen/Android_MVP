package com.seth.mvp_1

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() ,MvpView{

    private var progressDialog: ProgressDialog? = null
    private var presenter: MvpPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressDialog = ProgressDialog(this)
        progressDialog?.setCancelable(false)
        progressDialog?.setMessage("正在加载数据")

        presenter = MvpPresenter(this)
    }
    public fun getData(view: View){
        presenter?.getData("normal")
    }

    public fun getDataForFailure(view: View){
        presenter?.getData("failure")
    }

    public fun getDataForError(view: View){
        presenter?.getData("error")
    }

    override fun showLoading() {
        if(!progressDialog?.isShowing!!){
            progressDialog?.show()
        }
    }

    override fun hideLoading() {
        if(progressDialog?.isShowing!!){
            progressDialog?.dismiss()
        }
    }

    override fun showData(data: String) {
        text.text = data
    }

    override fun showFailureMessage(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        text.text = msg
    }

    override fun showErrorMessage() {
        Toast.makeText(this, "网络请求数据出现异常",Toast.LENGTH_SHORT).show()
        text.text = "网络请求数据出现异常"
    }

}
