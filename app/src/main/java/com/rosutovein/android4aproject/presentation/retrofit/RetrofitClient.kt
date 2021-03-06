package com.rosutovein.android4aproject.presentation.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var ourInstance:Retrofit?=null

    val instance:Retrofit
    get(){
        if(ourInstance == null)
            ourInstance = Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/Rosutovein/Android4AProject/master/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return ourInstance!!
    }
}