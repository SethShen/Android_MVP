package com.seth.routerail.http.response

import okhttp3.Response

/**
 * Created by hspcadmin on 2018/6/6.
 */
interface IResponseHandle{
    fun onSuccess(response: Response)
    fun onFailure(statusCode: Int, error_msg: String)
    fun onProgress(currentBytes: Long, totalBytes: Long)
}