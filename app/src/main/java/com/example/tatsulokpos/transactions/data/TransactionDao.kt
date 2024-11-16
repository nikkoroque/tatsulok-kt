package com.example.tatsulokpos.transactions.data

import com.example.tatsulokpos.transactions.model.TransactionModel

object TransactionDao {
    private val transactionModel: List<TransactionModel> = listOf(
        TransactionModel(
            id = 1,
            date = "2023-01-01",
            total = 100.00,
        ),
        TransactionModel(
            id = 2,
            date = "2023-01-02",
            total = 200.00,
        ),
        TransactionModel(
            id = 3,
            date = "2023-01-03",
            total = 300.00,
        ),
        TransactionModel(
            id = 4,
            date = "2023-01-04",
            total = 400.00,
        ),
        TransactionModel(
            id = 5,
            date = "2023-01-05",
            total = 500.00,
        ),
        TransactionModel(
            id = 6,
            date = "2023-01-06",
            total = 600.00,
        ),
    )
    fun getTransactions(): List<TransactionModel> {
        return transactionModel
    }
}