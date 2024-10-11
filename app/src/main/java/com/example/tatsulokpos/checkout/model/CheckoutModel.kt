package com.example.tatsulokpos.checkout.model

data class CheckoutModel(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val category: String,
)
