package com.example.tatsulokpos.transactions.services

import com.example.tatsulokpos.transactions.model.TransactionModel
import com.example.tatsulokpos.transactions.model.TransactionRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TransactionApiService {
    @GET("/api/transactions")
    suspend fun getTransactions(): List<TransactionModel>

    @POST("/api/transactions")
    suspend fun createTransaction(@Body transaction: TransactionRequest): Response<TransactionModel>

    @PUT("/api/transactions/{id}")
    suspend fun updateTransaction(@Path("id") id:Int, @Body transaction: TransactionModel): Response<TransactionModel>

    @POST("/api/transactions/{id}/void")
    suspend fun voidTransaction(
        @Path("id") id: Int,
        @Body voidRequest: VoidRequest
    ): Response<Unit>

    data class VoidRequest(
        val voidReason: String
    )
}

