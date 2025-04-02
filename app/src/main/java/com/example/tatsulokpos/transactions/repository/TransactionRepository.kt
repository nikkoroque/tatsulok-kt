package com.example.tatsulokpos.transactions.repository

import com.example.tatsulokpos.transactions.model.TransactionModel
import com.example.tatsulokpos.transactions.model.TransactionRequest
import com.example.tatsulokpos.transactions.services.TransactionApiService


class TransactionRepository(private val api: TransactionApiService) {
    suspend fun getTransactions(): List<TransactionModel> {
        return api.getTransactions()
    }

    suspend fun createTransaction(transaction: TransactionRequest): TransactionModel? {
        val response = api.createTransaction(transaction)

        return if (response.isSuccessful) response.body() else null
    }

    suspend fun voidTransaction(id: Int, voidReason: String): Boolean {
        return try {
            val response = api.voidTransaction(id, TransactionApiService.VoidRequest(voidReason))
            response.isSuccessful // Returns true if the response is successful
        } catch (e: Exception) {
            e.printStackTrace()
            false // Return false if an exception occurs
        }
    }
}