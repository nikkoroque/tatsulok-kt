package com.example.tatsulokpos.product.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tatsulokpos.product.model.CategoryModel
import com.example.tatsulokpos.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {
    private val _categories = MutableStateFlow<List<CategoryModel>>(emptyList())
    val categories: StateFlow<List<CategoryModel>> get() = _categories

    // Tag for Logcat messages
    private val TAG = "CategoryViewModel"

    fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.categoryApi.getCategories()

                // Log the response to Logcat
                Log.d(TAG, "Fetched categories: $response")

                _categories.value = response
            } catch (e: Exception) {
                // Log the error message to Logcat
                Log.e(TAG, "Error fetching categories: ${e.message}", e)
            }
        }
    }
}
