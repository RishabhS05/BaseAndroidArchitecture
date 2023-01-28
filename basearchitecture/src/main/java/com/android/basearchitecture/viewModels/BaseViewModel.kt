package com.android.basearchitecture.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.basearchitecture.datalayer.remote.IBaseTaskCode
import com.android.basearchitecture.model.BaseResponse
import com.android.basearchitecture.stateObject.RequestState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel(){
    abstract fun onSuccess(taskcode: IBaseTaskCode, response: BaseResponse)
    abstract fun onFailure(taskcode: IBaseTaskCode, exception: RequestState.Error)

    open fun onLoading(taskcode: IBaseTaskCode) {}
    fun <T> makeApiRequest(
        taskCode: IBaseTaskCode,
        isLoading: Boolean = true,
        call: suspend () -> Flow<RequestState<T>>,
    ) {
        viewModelScope.launch {
            call().collect {
                when (it) {
                    is RequestState.Success -> onSuccess(taskCode, it.data as BaseResponse)
                    is RequestState.Error -> onFailure(taskCode, it)
                    is RequestState.Loading -> if (isLoading) onLoading(taskCode)
                }
            }
        }
    }
}