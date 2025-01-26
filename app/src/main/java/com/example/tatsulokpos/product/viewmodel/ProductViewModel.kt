package com.example.tatsulokpos.product.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tatsulokpos.product.model.ProductModel
import com.example.tatsulokpos.api.RetrofitInstance
import com.example.tatsulokpos.product.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val repository = ProductRepository(RetrofitInstance.productApi)

    private val _products = MutableStateFlow<List<ProductModel>>(emptyList())
    val products: StateFlow<List<ProductModel>> get() = _products

    fun fetchAllProducts() {
        viewModelScope.launch {
            try {
                val productList = repository.getAllProducts()
                _products.value = productList
            } catch (e: Exception) {
                e.printStackTrace() // Handle error
            }
        }
    }
}
