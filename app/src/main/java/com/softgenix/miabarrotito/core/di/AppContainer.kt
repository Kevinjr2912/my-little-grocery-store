package com.softgenix.miabarrotito.core.di

import android.content.Context
import com.softgenix.miabarrotito.core.network.MiAbarrotitoApi
import com.softgenix.miabarrotito.features.auth.data.repositories.AuthRepositoryImplementation
import com.softgenix.miabarrotito.features.auth.domain.repositories.AuthRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer (context : Context) {



    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.200:3000/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

/*
    val jsonPlaceHolderApi : JsonPlaceHolderApi by lazy {
        retrofit.create(JsonPlaceHolderApi::class.java)
    }

    val postsRepository : PostsRepository by lazy {
        PostsRepositoryImpl(jsonPlaceHolderApi)
    }
    */

    val miAbarrotitoApi : MiAbarrotitoApi by lazy  {
        retrofit.create(MiAbarrotitoApi::class.java)
    }

    val authRepository : AuthRepository by lazy {
        AuthRepositoryImplementation(miAbarrotitoApi)
    }


}