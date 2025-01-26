package com.example.tatsulokpos.product.model

data class ProductModel(
    val product_id: Int,
    val name: String,
    val description: String,
    val category_id: Int,
    val quantity: Int,
    val price: Double,
    val img: String,
    val created_at: String,
    val updated_at: String
)
