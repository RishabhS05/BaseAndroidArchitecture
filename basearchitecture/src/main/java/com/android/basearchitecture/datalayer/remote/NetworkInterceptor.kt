package com.android.basearchitecture.datalayer.remote

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetworkInterceptor @Inject constructor() : Interceptor {
//    Apikey and token
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
            .method(request.method, request.body)
            .addHeader("Authorization", "Bearer" )
        return chain.proceed(builder.build())
    }
}