package com.seth.routerail.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.seth.routerail.R
import com.seth.routerail.`object`.RouteInfo
import kotlinx.android.synthetic.main.list_item_route.view.*

/**
 * Created by hspcadmin on 2018/7/6.
 */
class HomeAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val TYPE_HEADER = 0;
        val TYPE_FOOTER = 1;
        val TYPE_NORMAL = 2;
    }

    private val mDatas: ArrayList<RouteInfo> = arrayListOf()

    var mHeaderView: View? = null
    var mFooterView: View? = null

    fun setList(datas : ArrayList<RouteInfo>){
        mDatas.removeAll(mDatas)
        mDatas.addAll(datas)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if(getItemViewType(position) == TYPE_NORMAL){
            if(holder is RouteHolder){
                holder.itemView.item_route_name.text = mDatas?.get(position)?.routeName
                holder.itemView.item_route_shiftId .text = mDatas?.get(position)?.routeShiftId
                holder.itemView.item_route_leave_time.text = mDatas?.get(position)?.routeLeaveTime
                holder.itemView.item_route_cost_hours.text = mDatas?.get(position)?.routeCostTime
            }
        }else{
            return
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        if(mHeaderView != null && viewType == TYPE_HEADER){
            return RouteHolder(mHeaderView)
        }
        if(mFooterView != null && viewType == TYPE_FOOTER){
            return RouteHolder(mFooterView)
        }
        var layout = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_route,parent,false)
        return RouteHolder(layout)
    }

    override fun getItemCount(): Int {
        if(mHeaderView == null && mFooterView == null){
            return mDatas!!.size;
        }else if(mHeaderView == null && mFooterView != null){
            return mDatas!!.size + 1
        }else if(mHeaderView != null && mFooterView == null){
            return mDatas!!.size + 1
        }else{
            return mDatas!!.size + 2
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(mHeaderView == null && mFooterView == null){
            return TYPE_NORMAL
        }
        when(position){
            0 -> return TYPE_HEADER
            itemCount-1 -> return TYPE_FOOTER
            else -> return TYPE_NORMAL
        }
    }

    inner class RouteHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
//        lateinit var RouteName: TextView
//        lateinit var RouteShfitId: TextView
//        lateinit var RouteLeaveTime: TextView
//        lateinit var RouteCostTime: TextView
//        init {
//            if(itemView != mHeaderView && itemView!= mFooterView){
//                RouteName = itemView?.findViewById(R.id.item_route_name)!!
//                RouteShfitId = itemView?.findViewById(R.id.item_route_shiftId)
//                RouteLeaveTime = itemView?.findViewById(R.id.item_route_leave_time)
//                RouteCostTime = itemView?.findViewById(R.id.item_route_cost_hours)
//            }
//        }
    }



}