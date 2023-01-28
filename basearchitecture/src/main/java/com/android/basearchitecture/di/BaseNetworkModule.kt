package com.android.basearchitecture.di

import com.android.basearchitecture.datalayer.remote.NetworkInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import com.android.basearchitecture.BuildConfig
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
open class BaseNetworkModule {
    open fun getBaseUrl() : String = ""
    @Singleton
    @Provides
    fun providerOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.apply {
            connectTimeout(5L, TimeUnit.MINUTES)
            if (BuildConfig.DEBUG)
                builder.addInterceptor(providerHttpsLoggingInterceptor())
            val interceptors = getInterceptors()
            interceptors.forEach { interceptor ->
                addInterceptor(interceptor)
            }
        }
        return builder.build()
    }

    private fun providerHttpsLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient,): Retrofit {
        return Retrofit.Builder().baseUrl(getBaseUrl())
            .client(okHttpClient)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
//            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    open fun getInterceptors(): ArrayList<Interceptor> {
        return arrayListOf(NetworkInterceptor())
    }
}