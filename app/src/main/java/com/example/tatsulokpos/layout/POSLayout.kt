package com.example.tatsulokpos.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tatsulokpos.layout.viewmodel.CartViewModel
import com.example.tatsulokpos.product.model.CartItemModel

@Composable
fun POSLayout(
    navController: NavHostController,
    cartViewModel: CartViewModel = viewModel() // Inject CartViewModel
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Main screen for products
        MainScreen(
            onAddToCart = { product ->
                // Add product to the cart using CartViewModel
                cartViewModel.addToCart(CartItemModel(product, 1))
            },
            modifier = Modifier.weight(0.7f)
        )

        // Cart display for managing and viewing cart items
        CartDisplay(
            viewModel = cartViewModel, // Pass the CartViewModel to CartDisplay
            modifier = Modifier.weight(0.3f) // Pass the modifier
        )
    }
}

