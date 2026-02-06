package com.softgenix.miabarrotito.core.di

import android.content.Context
import com.softgenix.miabarrotito.core.network.MiAbarrotitoApi
import com.softgenix.miabarrotito.features.auth.data.datasoruces.local.AuthLocalDataSource
import com.softgenix.miabarrotito.features.auth.data.repositories.AuthRepositoryImplementation
import com.softgenix.miabarrotito.features.auth.domain.repositories.AuthRepository
import com.softgenix.miabarrotito.features.product_management.data.repositories.ProductRepositoryImplementation
import com.softgenix.miabarrotito.features.product_management.domain.repositories.ProductRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer (context : Context) {



    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.200:3000/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//    private val retrofit: Retrofit = Retrofit.Builder()
//        .baseUrl("http://192.168.1.206:3000/api/v1/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
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

    private val authLocalDataSource by lazy {
        AuthLocalDataSource(context)
    }

    val authRepository : AuthRepository by lazy {
        AuthRepositoryImplementation(miAbarrotitoApi, authLocalDataSource)
    }

    val productRepository : ProductRepository by lazy {
        ProductRepositoryImplementation(miAbarrotitoApi)
    }


}