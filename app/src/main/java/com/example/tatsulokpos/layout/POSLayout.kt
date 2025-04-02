package com.example.tatsulokpos.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tatsulokpos.layout.viewmodel.CartViewModel
import com.example.tatsulokpos.product.model.CartItemModel
import com.example.tatsulokpos.transactions.viewmodel.TransactionViewModel

@Composable
fun POSLayout(
    navController: NavHostController,
    cartViewModel: CartViewModel = viewModel(), // ✅ Ensure CartViewModel is provided
    transactionViewModel: TransactionViewModel = viewModel() // ✅ Ensure TransactionViewModel is provided
) {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        // Main product screen
        MainScreen(
            onAddToCart = { product ->
                cartViewModel.addToCart(CartItemModel(product, 1))
            },
            modifier = Modifier.weight(0.7f)
        )

        // ✅ Ensure CartDisplay receives both view models
        CartDisplay(
            cartViewModel = cartViewModel,
            transactionViewModel = transactionViewModel,
            modifier = Modifier.weight(0.3f)
        )
    }
}
