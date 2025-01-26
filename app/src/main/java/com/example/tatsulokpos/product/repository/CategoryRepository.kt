package com.example.tatsulokpos.product.repository

import com.example.tatsulokpos.product.model.CategoryModel
import com.example.tatsulokpos.product.services.CategoryApiService

class CategoryRepository(private val api: CategoryApiService) {
    suspend fun getAllCategories(): List<CategoryModel> {
        return api.getCategories()
    }
}