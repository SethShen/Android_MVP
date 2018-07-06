package com.seth.routerail.`object`

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by hspcadmin on 2018/7/6.
 */
data class RouteInfo (
        var routeName:String,
        var routeShiftId: String,
        var routeLeaveTime: String,
        var routeCostTime: String
):Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(routeName)
        parcel.writeString(routeShiftId)
        parcel.writeString(routeLeaveTime)
        parcel.writeString(routeCostTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RouteInfo> {
        override fun createFromParcel(parcel: Parcel): RouteInfo {
            return RouteInfo(parcel)
        }

        override fun newArray(size: Int): Array<RouteInfo?> {
            return arrayOfNulls(size)
        }
    }

}