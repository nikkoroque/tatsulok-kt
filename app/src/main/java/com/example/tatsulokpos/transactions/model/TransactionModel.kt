package com.example.tatsulokpos.transactions.model

data class TransactionModel (
    val transaction_id: Int,
    val product_id: String,
    val quantity: Int,
    val transaction_type: String,
    val transaction_date: String,
    val remarks: String,
    val amount: Double,
)