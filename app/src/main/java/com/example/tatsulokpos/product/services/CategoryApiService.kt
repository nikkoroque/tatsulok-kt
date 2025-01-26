package com.example.tatsulokpos.product.services

import com.example.tatsulokpos.product.model.CategoryModel
import retrofit2.http.GET

interface CategoryApiService {
    @GET("/api/categories")
    suspend fun getCategories(): List<CategoryModel>
}