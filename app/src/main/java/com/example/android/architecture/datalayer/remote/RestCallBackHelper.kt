package com.example.android.architecture.datalayer.remote

import com.android.basearchitecture.model.BaseResponse


interface RestCallBackHelper {
    fun onSuccess(taskcode: Taskcode, response: BaseResponse)
    fun onFailure(taskcode: Taskcode, exception: String)
    fun onLoading(taskcode: Taskcode)
}