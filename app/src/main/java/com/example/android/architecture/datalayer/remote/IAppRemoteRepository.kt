package com.example.android.architecture.datalayer.remote

import com.android.basearchitecture.stateObject.RequestState
import com.example.android.architecture.model.LocationListModelResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface IAppRemoteRepository  {
    suspend fun getNearByLocations() : Flow<RequestState<LocationListModelResponse>>
}