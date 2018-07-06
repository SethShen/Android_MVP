package com.seth.routerail


import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.view.View
import com.seth.routerail.base.BaseDrawerActivity
import com.seth.routerail.fragment.home.RouteCitiesFragment
import com.seth.routerail.presenter.MvpPresenter
import com.seth.routerail.view.MvpView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseDrawerActivity(), MvpView {


    private var presenter: MvpPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        statusBarColor = resources.getColor(R.color.color_bg)
        super.onCreate(savedInstanceState)
        addMainContentView(R.layout.activity_main)

        presenter = MvpPresenter().apply {
            attachView(this@MainActivity)
        }
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
    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
    }

}
