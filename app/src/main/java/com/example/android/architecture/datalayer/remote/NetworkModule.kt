package com.example.android.architecture.datalayer.remote

import com.android.basearchitecture.di.BaseNetworkModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.android.architecture.BuildConfig.BASE_URL
import com.example.android.architecture.datalayer.APIService
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule : BaseNetworkModule() {
     override fun getBaseUrl(): String  = BASE_URL
     @Singleton
     @Provides
     fun providesApiService(retrofit: Retrofit): APIService {
          return retrofit.create(APIService::class.java)
     }
}