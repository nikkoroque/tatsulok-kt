package com.example.tatsulokpos.product.model


data class ProductModel(
    val id: Int,
    val sku: String,
    val name: String,
    val description: String,
    val price: Double,
    val categoryId: Int,
    val featuredImage: String,
    val featuredProduct: Boolean,
)
