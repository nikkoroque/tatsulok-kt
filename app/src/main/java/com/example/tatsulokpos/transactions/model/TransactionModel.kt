package com.example.tatsulokpos.transactions.model

data class TransactionModel(
    val transaction_id: Int, // Ensure this is named correctly
    val product_id: String,
    val quantity: Int,
    val transaction_type: String,
    val transaction_date: String,
    val remarks: String,
    val amount: Double,
)

data class TransactionRequest(
    val productId: Int,
    val quantity: Int,
    val amount: Double,
    val transactionType: String,
    val remarks: String
)