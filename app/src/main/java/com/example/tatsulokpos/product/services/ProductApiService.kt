package com.example.tatsulokpos.product.services

import com.example.tatsulokpos.product.model.ProductModel
import retrofit2.http.GET

interface ProductApiService {
    @GET("/api/products")
    suspend fun getProducts(): List<ProductModel>
}