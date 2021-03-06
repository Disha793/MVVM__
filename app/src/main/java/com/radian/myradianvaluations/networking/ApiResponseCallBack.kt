package com.radian.myradianvaluations.networking

import com.radian.myradianvaluations.networking.ReturnType

interface ApiResponseCallBack {
    fun onPreExecute(returnType: ReturnType)
    fun onSuccess(returnType: ReturnType, response: String)
    fun onError(returnType: ReturnType, error: String)
}