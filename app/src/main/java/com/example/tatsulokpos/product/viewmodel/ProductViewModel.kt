package com.example.tatsulokpos.product.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tatsulokpos.product.model.ProductModel
import com.example.tatsulokpos.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val _products = MutableStateFlow<List<ProductModel>>(emptyList())
    val products: StateFlow<List<ProductModel>> get() = _products

    fun fetchProducts() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.productsApi.getProducts()
                _products.value = response
            } catch (e: Exception) {
                e.printStackTrace() // Log or handle error
            }
        }
    }
}
