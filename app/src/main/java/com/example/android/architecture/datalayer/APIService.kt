package com.example.android.architecture.datalayer

import com.example.android.architecture.datalayer.remote.AppConstants
import com.example.android.architecture.model.LocationListModelResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIService  {
    @GET(AppConstants.getLocations)
    suspend fun getNearByLocations(): Response<LocationListModelResponse>
}