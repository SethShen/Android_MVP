package com.seth.mvp_2


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.seth.mvp_2.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MvpView {

    private var presenter: MvpPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MvpPresenter().apply {
            attachView(this@MainActivity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
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


    override fun showData(data: String) {
        text.text = data
    }

}
