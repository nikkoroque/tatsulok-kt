package com.example.tatsulokpos.checkout.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tatsulokpos.layout.CartDisplay
import com.example.tatsulokpos.product.model.CartItemModel
import com.example.tatsulokpos.utils.currencyFormatter
import org.w3c.dom.Text


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

//@Composable
//fun CheckOutButton(){
//    var showDialog by remember{ mutableStateOf(false)}
//    var showCheckOutMessage by remember { mutableStateOf(false) }
//    Box(Modifier.fillMaxWidth()){
//        Button(onClick = { showDialog = true}, modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth(), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White)) {
//            Text(text = "Checkout")
//        }
//    }
//    // Show the dialog conditionally
//    if (showDialog) {
//   PaymentOptionsDialog(showDialog = showDialog,
//       onDismiss = { showDialog = false },  // Dismiss the dialog
//       onConfirm = {
//           showDialog = false
//           showCheckOutMessage = true;
//           // You can also add more logic for handling the checkout here
//       })
//    }
//
//    if(showCheckOutMessage){
//        CheckOutMessage( onDismiss = { showCheckOutMessage = false })
//    }
//
//
//}

@Composable
fun CheckOutButton(onCheckoutComplete: () -> Unit) {
    var showDialog by remember { mutableStateOf(false) }
    var showCheckOutMessage by remember { mutableStateOf(false) }

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
                showCheckOutMessage = true
                onCheckoutComplete() // Clear cart items after checkout
            }
        )
    }

    if (showCheckOutMessage) {
        CheckOutMessage(onDismiss = { showCheckOutMessage = false })
    }
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
            title = { Text(text = "Choose Payment Option") },
            text = {
                Column {
                    // Each option displays an image instead of text
                    PaymentOptionRow(
                        option = "Gcash",
                        selectedModeOfPayment = selectedOption,
                        imageUrl = "https://media.licdn.com/dms/image/C5612AQGaOlwdWwWOyg/article-cover_image-shrink_600_2000/0/1610443196243?e=2147483647&v=beta&t=tDEZDdlZ7VDvyK2bXoZvwuzcnJ39MjzpwOd3e1pF5_o", // Replace with actual image URL or resource
                        onSelect = { selectedOption = it }
                    )
                    PaymentOptionRow(
                        option = "Cash",
                        selectedModeOfPayment = selectedOption,
                        imageUrl = "https://media.istockphoto.com/id/1270169656/photo/paying-and-receiving-of-philippine-peso-bills-on-white-background.jpg?s=612x612&w=0&k=20&c=3Rc2GTowUuoJuCNGeRjD4u4l26Fi0MkQUcGRuI2flYo=", // Replace with actual image URL or resource
                        onSelect = { selectedOption = it }
                    )
                    PaymentOptionRow(
                        option = "Debit or Credit Card",
                        selectedModeOfPayment = selectedOption,
                        imageUrl = "https://streetfins.com/wp-content/uploads/2020/12/debt-vs-credit-11.jpg", // Replace with actual image URL or resource
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
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect(option) } // Make the entire row clickable
            .padding(vertical = 8.dp)
    ) {
        // Load the image for the payment option
        AsyncImage(
            model = imageUrl,
            contentDescription = option,
            modifier = Modifier
                .size(80.dp) // Adjust size as needed
                .clip(RoundedCornerShape(4.dp)) // Optional: round the corners of the image
                .padding(4.dp) // Optional: add some padding around the image
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Display the option text, optional if you only want the images
        Text(option, modifier = Modifier.align(Alignment.CenterVertically))
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




