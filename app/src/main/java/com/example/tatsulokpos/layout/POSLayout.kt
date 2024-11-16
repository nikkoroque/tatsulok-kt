package com.example.tatsulokpos.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.tatsulokpos.product.model.CartItemModel


@Composable
fun POSLayout(navController: NavHostController) {
    var cartItems by remember { mutableStateOf(listOf<CartItemModel>()) }

    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MainScreen(
            onAddToCart = { product ->
                val existingItemIndex = cartItems.indexOfFirst { it.product.id == product.id }
                if (existingItemIndex >= 0) {
                    val updatedCartItems = cartItems.toMutableList().apply {
                        val existingItem = this[existingItemIndex]
                        this[existingItemIndex] = existingItem.copy(quantity = existingItem.quantity + 1)
                    }
                    cartItems = updatedCartItems
                } else {
                    cartItems = cartItems + CartItemModel(product, 1)
                }
            },
            modifier = Modifier.weight(0.7f)
        )
        CartDisplay(
            cartItems = cartItems,
            onClearCart = { cartItems = listOf() }, // Clear cart items on checkout
            modifier = Modifier.weight(0.3f)
        )
    }

}