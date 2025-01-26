package com.example.tatsulokpos.layout.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tatsulokpos.product.model.CartItemModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CartViewModel : ViewModel() {
    private val _cartItems = MutableStateFlow<List<CartItemModel>>(emptyList())
    val cartItems: StateFlow<List<CartItemModel>> = _cartItems

    // Add an item to the cart
    fun addToCart(cartItem: CartItemModel) {
        val existingItem = _cartItems.value.find { it.product.product_id == cartItem.product.product_id }
        if (existingItem != null) {
            // Increase quantity if the item already exists
            _cartItems.value = _cartItems.value.map {
                if (it.product.product_id == cartItem.product.product_id) it.copy(quantity = it.quantity + 1) else it
            }
        } else {
            // Add new item
            _cartItems.value = _cartItems.value + cartItem
        }
    }

    // Increase the quantity of an item
    fun increaseQuantity(cartItem: CartItemModel) {
        _cartItems.value = _cartItems.value.map {
            if (it.product.product_id == cartItem.product.product_id) it.copy(quantity = it.quantity + 1) else it
        }
    }

    // Decrease the quantity of an item
    fun decreaseQuantity(cartItem: CartItemModel) {
        _cartItems.value = _cartItems.value.mapNotNull {
            if (it.product.product_id == cartItem.product.product_id) {
                if (it.quantity > 1) it.copy(quantity = it.quantity - 1) else null // Remove item if quantity reaches 0
            } else it
        }
    }

    // Clear the cart
    fun clearCart() {
        _cartItems.value = emptyList()
    }
}
