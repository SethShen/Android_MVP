package com.seth.routerail.fragment.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seth.routerail.R
import kotlinx.android.synthetic.main.fragment_select_cities.*

/**
 * Created by seth on 2018/7/5.
 */
class RouteCitiesFragment : Fragment(), View.OnClickListener {
//    lateinit var startCity: TextView
//    lateinit var endCity: TextView
//    lateinit var changeCity: ImageView
//    lateinit var searchRoute: RelativeLayout
//
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.fragment_select_cities, container, false)
        return view
        initView()
        initEvent()
    }

    fun initEvent(){
        start_city_tv.setOnClickListener(this)
        end_city_tv.setOnClickListener(this)
        cities_change_img.setOnClickListener(this)
        route_search_rl.setOnClickListener(this)
    }

    fun initView(){
    }
    override fun onClick(v: View?) {
        when(v?.id){

        }
    }

}