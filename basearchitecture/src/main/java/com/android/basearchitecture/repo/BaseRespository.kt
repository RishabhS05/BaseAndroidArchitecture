package com.android.basearchitecture.repo

import com.android.basearchitecture.stateObject.RequestState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

open class BaseRespository {
    fun <T> getResultFlow(
        apiCall: suspend () -> Response<T>?
    ): Flow<RequestState<T>> = flow {
        emit(RequestState.Loading)
        try {
            val response = apiCall()
            response?.let { rawResponse ->
                when (rawResponse.code()) {
                    200 -> emit(RequestState.Success(data = rawResponse.body()!!))
                    in 400..504 ->
                        rawResponse.errorBody()?.let {
                            val error = it.string()
//                            val baseError= Gson().fromJson(error, DetailedError::class.java)
                            it.close()
//                            emit(RequestState.Error(baseError,rawResponse.code()))
                        }
                    else -> {
                        emit(RequestState.Error(Exception("Something went wrong !!")))
                    }
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
            emit(RequestState.Error(e))
        }
    }.flowOn(Dispatchers.IO)
}