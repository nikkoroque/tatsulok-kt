package com.example.tatsulokpos.transactions.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tatsulokpos.api.RetrofitInstance
import com.example.tatsulokpos.transactions.model.TransactionModel
import com.example.tatsulokpos.transactions.model.TransactionRequest
import com.example.tatsulokpos.transactions.repository.TransactionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TransactionViewModel : ViewModel() {
    private val repository = TransactionRepository(RetrofitInstance.transactionApi)

    // State for the list of transactions
    private val _transactions = MutableStateFlow<List<TransactionModel>>(emptyList())
    val transactions: StateFlow<List<TransactionModel>> get() = _transactions

    // State for transaction result (e.g., success/failure for create/void)
    private val _transactionResult = MutableStateFlow<Boolean?>(null)
    val transactionResult: StateFlow<Boolean?> get() = _transactionResult

    /**
     * Fetch all transactions.
     */
    fun fetchAllTransactions() {
        viewModelScope.launch {
            try {
                val transactionList = repository.getTransactions()
                _transactions.value = transactionList
            } catch (e: Exception) {
                e.printStackTrace() // Handle error
                _transactions.value = emptyList() // Reset to empty list on error
            }
        }
    }

    /**
     * Create a new transaction.
     * @param transaction The transaction to create.
     */
    fun createTransaction(transaction: TransactionRequest) {
        viewModelScope.launch {
            try {
                val newTransaction = repository.createTransaction(transaction)
                if (newTransaction != null) {
                    println("Transaction successful: $newTransaction")
                    _transactionResult.value = true // Indicate success
                } else {
                    println("Transaction failed: Response is null")
                    _transactionResult.value = false // Indicate failure
                }
            } catch (e: Exception) {
                e.printStackTrace()
                println("Transaction failed: ${e.message}")
                _transactionResult.value = false
            }
        }
    }
    /**
     * Void a transaction by its ID.
     * @param id The ID of the transaction to void.
     * @param voidReason The reason for voiding the transaction.
     */
    fun voidTransaction(id: Int, voidReason: String) {
        viewModelScope.launch {
            try {
                val success = repository.voidTransaction(id, voidReason)
                if (success) {
                    _transactions.value = _transactions.value.filter { it.transaction_id != id } // Remove the voided transaction
                }
                _transactionResult.value = success // Indicate the result of voiding
            } catch (e: Exception) {
                e.printStackTrace()
                _transactionResult.value = false
            }
        }
    }
}
