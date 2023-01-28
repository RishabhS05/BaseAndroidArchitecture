package com.example.android.architecture.ui.applevel

import com.android.basearchitecture.datalayer.remote.IBaseTaskCode
import com.android.basearchitecture.model.BaseResponse
import com.android.basearchitecture.stateObject.RequestState
import com.android.basearchitecture.viewModels.BaseViewModel
import com.example.android.architecture.datalayer.remote.Taskcode
import com.example.android.architecture.repos.IbaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
open class AppBaseViewModel @Inject constructor(private val repository: IbaseRepository) : BaseViewModel() {

    fun getNearByLocations() = makeApiRequest(Taskcode.GET_NEAR_BY_LOCATIONS) { repository.getNearByLocations() }

    override fun onSuccess(taskcode: IBaseTaskCode, response: BaseResponse) {
        when(taskcode as Taskcode){
            Taskcode.GET_NEAR_BY_LOCATIONS-> {
//                Todo implement api calls
            }
            // implement else to avoid compile time error
            else ->{}
        }
    }

    override fun onFailure(taskcode: IBaseTaskCode, exception: RequestState.Error) {
        when(taskcode as Taskcode){
            Taskcode.GET_NEAR_BY_LOCATIONS-> {
//                Todo implement api calls
            }
            // implement else to avoid compile time error
            else ->{}
        }
    }
}