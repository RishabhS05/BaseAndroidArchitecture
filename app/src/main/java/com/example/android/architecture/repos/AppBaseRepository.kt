package com.example.android.architecture.repos

import com.android.basearchitecture.repo.BaseRespository
import com.android.basearchitecture.stateObject.RequestState
import com.example.android.architecture.datalayer.APIService
import com.example.android.architecture.model.LocationListModelResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

open class AppBaseRepository @Inject constructor(private val apiService: APIService) : BaseRespository(), IbaseRepository {
    override suspend fun getNearByLocations(): Flow<RequestState<LocationListModelResponse>> = getResultFlow {
        apiService.getNearByLocations()
    }
}