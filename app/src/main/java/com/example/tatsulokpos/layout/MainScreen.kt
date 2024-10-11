package com.example.tatsulokpos.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tatsulokpos.product.model.ProductModel
import com.example.tatsulokpos.product.ui.Categories
import com.example.tatsulokpos.product.ui.Products


@Composable
fun MainScreen(onAddToCart: (ProductModel) -> Unit, modifier: Modifier = Modifier) {
    var selectedCategoryId by remember { mutableStateOf(1) }
    Column(
        modifier = modifier.padding(16.dp) // Padding for better UI appearance
    ) {
        Categories(onCategorySelected = { categoryId -> selectedCategoryId = categoryId})
        Spacer(modifier = Modifier.height(16.dp))
        Products(selectedCategoryId = selectedCategoryId, onAddToCart = onAddToCart)

    }
}