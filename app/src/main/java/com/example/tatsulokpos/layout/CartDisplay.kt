package com.example.tatsulokpos.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tatsulokpos.checkout.ui.CheckOutSection
import com.example.tatsulokpos.checkout.ui.CheckOutButton
import com.example.tatsulokpos.components.header.HeaderSection
import com.example.tatsulokpos.product.model.CartItemModel
import com.example.tatsulokpos.utils.currencyFormatter


@Composable
fun CartDisplay(cartItems: List<CartItemModel>, onClearCart: () -> Unit, modifier: Modifier = Modifier) {
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
                        .weight(1f)  // Restrict the height to available space only
                        .padding(bottom = 16.dp)  // Add extra padding to stop behind total section
                ) {
                    items(cartItems.size) { index ->
                        CartCard(index, cartItems)
                    }
                }
            }
        }

        // Bottom Checkout and Total Section
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(8.dp)) // Optional: Add background to make it more visible
        ) {
            CheckOutSection(initialPrice)

            Spacer(modifier = Modifier.height(10.dp))

            CheckOutButton(onCheckoutComplete = onClearCart)
        }
    }
}




@Composable
fun CartCard(index: Int, cartItems: List<CartItemModel>) {
    val cartItem = cartItems[index]
    val totalPrice = cartItem.product.price * cartItem.quantity

    Box(modifier = Modifier.padding(vertical = 1.dp).padding(start = 10.dp, end = 10.dp)) {
        Column(modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFFEFEFA))
            .fillMaxWidth()
            .height(70.dp)
            .padding(vertical = 5.dp, horizontal = 5.dp),
            verticalArrangement = Arrangement.Center
        ) {
             Text(
                 text = cartItem.product.sku,
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
                        model = cartItem.product.featuredImage,
                        contentDescription = cartItem.product.sku,
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
                    Text(
                        text = " x ${cartItem.quantity}",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
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

fun RemoveCartItem(cartItem: CartItemModel) {
}

