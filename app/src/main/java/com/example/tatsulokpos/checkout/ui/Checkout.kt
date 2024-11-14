package com.example.tatsulokpos.checkout.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tatsulokpos.utils.currencyFormatter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun CheckOutSection(price : Double) {
    Box(modifier = Modifier.fillMaxWidth()) {
        // This will always stay at the bottom of the screen
        Text(
            text = "Total: ${currencyFormatter(price)}",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp) // Optional padding to adjust position
        )
    }
}

@Composable
fun CheckOutButton(onCheckoutComplete: () -> Unit) {
    var showDialog by remember { mutableStateOf(false) }
    var showCheckOutMessage by remember { mutableStateOf(false) }
    var isProcessing by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Box(Modifier.fillMaxWidth()) {
        Button(
            onClick = { showDialog = true },
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White)
        ) {
            Text(text = "Checkout")
        }
    }

    if (showDialog) {
        PaymentOptionsDialog(
            showDialog = showDialog,
            onDismiss = { showDialog = false },
            onConfirm = {
                showDialog = false
                isProcessing = true
                coroutineScope.launch {
                    delay(2000) // Simulate payment processing delay
                    isProcessing = false
                    showCheckOutMessage = true
                    onCheckoutComplete() // Clear cart items after checkout
                }
            }
        )
    }

    if (isProcessing) {
        ProcessingMessage()
    }

    if (showCheckOutMessage) {
        CheckOutMessage(onDismiss = { showCheckOutMessage = false })
    }
}

@Composable
fun ProcessingMessage() {
    AlertDialog(
        onDismissRequest = {},
        title = null,
        text = { Text("Simulating Payment Process...") },
        confirmButton = {}
    )
}


@Composable
fun PaymentOptionsDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit // Passes the selected payment option to the confirm action
) {
    if (showDialog) {
        var selectedOption by remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Choose Payment Option", fontWeight = FontWeight.Bold) },
            text = {
                Column {
                    PaymentOptionRow(
                        option = "Creditcard/Non-Creditcard Installment Payments",
                        selectedModeOfPayment = selectedOption,
                        imageUrl = "https://i.imgur.com/EIqzXLb.png",
                        onSelect = { selectedOption = it }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    PaymentOptionRow(
                        option = "Credit/Debit Card Payments",
                        selectedModeOfPayment = selectedOption,
                        imageUrl = "https://i.imgur.com/PnUYhLr.png",
                        onSelect = { selectedOption = it }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    PaymentOptionRow(
                        option = "eWallet Payments",
                        selectedModeOfPayment = selectedOption,
                        imageUrl = "https://i.imgur.com/EIX5Ooo.png",
                        onSelect = { selectedOption = it }
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = { onConfirm(selectedOption) },
                    enabled = selectedOption.isNotEmpty()
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                Button(onClick = { onDismiss() }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun PaymentOptionRow(
    option: String,
    selectedModeOfPayment: String,
    imageUrl: String, // URL or resource ID for the image
    onSelect: (String) -> Unit
) {
    val isSelected = selectedModeOfPayment == option
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = if (isSelected) 2.dp else 1.dp,
                color = if (isSelected) Color.Black else Color.Gray,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onSelect(option) } // Make the entire row clickable
            .padding(8.dp)
    ) {
        // Load the image for the payment option
        // Display the option text
        Text(option, modifier = Modifier.align(Alignment.Start), fontSize = 18.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.width(8.dp))

        AsyncImage(
            model = imageUrl,
            contentDescription = option,
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .padding(4.dp)
        )

    }
}

@Composable
fun CheckOutMessage(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = null, // No title
        text = {
            Text("Transaction done!")
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("OK")
            }
        }
    )
}




