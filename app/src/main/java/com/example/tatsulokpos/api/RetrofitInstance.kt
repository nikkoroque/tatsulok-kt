package com.example.tatsulokpos.api

import com.example.tatsulokpos.product.services.CategoryApiService
import com.example.tatsulokpos.product.services.ProductApiService
import com.example.tatsulokpos.transactions.services.TransactionApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "http://10.0.2.2:8000" // Use 10.0.2.2 for localhost in Android emulator

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val productApi: ProductApiService by lazy {
        retrofit.create(ProductApiService::class.java)
    }

    val categoryApi: CategoryApiService by lazy {
        retrofit.create(CategoryApiService::class.java)
    }

    val transactionApi: TransactionApiService by lazy {
        retrofit.create(TransactionApiService::class.java)
    }
}