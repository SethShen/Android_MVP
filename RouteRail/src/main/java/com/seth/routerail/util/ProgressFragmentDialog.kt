package com.seth.routerail.util

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seth.routerail.R

/**
 * Created by hspcadmin on 2018/6/21.
 */
class ProgressFragmentDialog : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater?.inflate(R.layout.dialog_fragment_progressbar, container, false)
        return view!!;
    }

}