package com.example.tatsulokpos.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tatsulokpos.components.navigation.BottomNavigationBar
import com.example.tatsulokpos.product.model.CartItemModel


@Preview(showBackground = true, widthDp = 1024, heightDp = 768)
@Composable
fun POSLayout() {
    var cartItems by remember { mutableStateOf(listOf<CartItemModel>()) }

    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { innerPadding ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
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

            CartDisplay(cartItems = cartItems, modifier = Modifier.weight(0.3f))
        }
    }
}