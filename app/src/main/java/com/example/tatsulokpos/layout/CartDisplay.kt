package com.example.tatsulokpos.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.tatsulokpos.checkout.ui.CheckOutButton
import com.example.tatsulokpos.checkout.ui.CheckOutSection
import com.example.tatsulokpos.components.header.HeaderSection
import com.example.tatsulokpos.product.model.CartItemModel
import com.example.tatsulokpos.utils.currencyFormatter
import com.example.tatsulokpos.layout.viewmodel.CartViewModel
import com.example.tatsulokpos.transactions.viewmodel.TransactionViewModel

@Composable
fun CartDisplay(
    cartViewModel: CartViewModel,
    transactionViewModel: TransactionViewModel, // Added TransactionViewModel
    modifier: Modifier = Modifier
) {
    val cartItems = cartViewModel.cartItems.collectAsState().value
    val initialPrice = cartItems.sumOf { it.product.price * it.quantity }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 100.dp) // Reserve space for checkout section
        ) {
            Text(text = "Cart", style = MaterialTheme.typography.headlineLarge)
            HeaderSection()

            if (cartItems.isEmpty()) {
                Text("No items in cart")
            } else {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = 16.dp)
                ) {
                    items(cartItems.size) { index ->
                        CartCard(
                            cartItem = cartItems[index],
                            onIncreaseQuantity = { cartViewModel.increaseQuantity(it) },
                            onDecreaseQuantity = { cartViewModel.decreaseQuantity(it) }
                        )
                    }
                }
            }
        }

        // Bottom Checkout and Total Section
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(8.dp))
        ) {
            CheckOutSection(initialPrice)

            Spacer(modifier = Modifier.height(10.dp))

            // Pass TransactionViewModel
            CheckOutButton(
                cartViewModel = cartViewModel,  // ✅ Pass cartViewModel
                transactionViewModel = transactionViewModel,
                onCheckoutComplete = { cartViewModel.clearCart() }
            )
        }
    }
}

@Composable
fun CartCard(
    cartItem: CartItemModel,
    onIncreaseQuantity: (CartItemModel) -> Unit,
    onDecreaseQuantity: (CartItemModel) -> Unit
) {
    val totalPrice = cartItem.product.price * cartItem.quantity

    Box(modifier = Modifier.padding(vertical = 1.dp).padding(start = 10.dp, end = 10.dp)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFEFEFA))
                .fillMaxWidth()
                .height(90.dp)
                .padding(vertical = 5.dp, horizontal = 5.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = cartItem.product.product_id.toString(),
                color = Color.LightGray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    AsyncImage(
                        model = cartItem.product.img,
                        contentDescription = cartItem.product.product_id.toString(),
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .clip(RoundedCornerShape(5.dp))
                    )
                    Text(
                        text = cartItem.product.name,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }

                // Quantity Adjustment Buttons
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { onDecreaseQuantity(cartItem) },
                        modifier = Modifier.size(30.dp)
                    ) {
                        Text(
                            text = "-",
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(
                        text = cartItem.quantity.toString(),
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    IconButton(
                        onClick = { onIncreaseQuantity(cartItem) },
                        modifier = Modifier.size(30.dp)
                    ) {
                        Text(
                            text = "+",
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                // Total Price
                Text(
                    text = currencyFormatter(totalPrice),
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}
