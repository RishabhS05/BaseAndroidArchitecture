package com.android.basearchitecture.model

open class BaseResponse(var error: Exception?= null,
                        var statusCode: Int = 0,
                        var message : String? =null,)