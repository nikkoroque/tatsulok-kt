package com.example.tatsulokpos.product.repository

import com.example.tatsulokpos.product.model.ProductModel
import com.example.tatsulokpos.product.services.ProductApiService

class ProductRepository(private val api: ProductApiService) {
    suspend fun getAllProducts(): List<ProductModel> {
        return api.getAllProducts()
    }
}