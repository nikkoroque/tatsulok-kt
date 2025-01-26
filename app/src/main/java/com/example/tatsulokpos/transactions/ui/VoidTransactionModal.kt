package com.example.tatsulokpos.transactions.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tatsulokpos.transactions.model.TransactionModel

@Composable
fun VoidTransactionModal(
    transaction: TransactionModel?,
    onDismiss: () -> Unit,
    onSubmit: (String) -> Unit
) {
    // Local state to store the void reason
    val voidReason = remember { mutableStateOf("") }

    // Modal container
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)) // Dim the background
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Modal content
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title
            Text(
                text = "Void Transaction",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.primary
            )

            // Transaction details
            Text(
                text = "Transaction ID: ${transaction?.transaction_id ?: "N/A"}",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                color = Color.Gray
            )
            Text(
                text = "Product ID: ${transaction?.product_id ?: "N/A"}",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                color = Color.Gray
            )

            // Input field for the void reason
            OutlinedTextField(
                value = voidReason.value,
                onValueChange = { voidReason.value = it },
                label = { Text("Reason") },
                placeholder = { Text("Enter reason for voiding") },
                modifier = Modifier.fillMaxWidth()
            )

            // Buttons for Cancel and Submit
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Cancel button
                Button(
                    onClick = onDismiss,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.errorContainer)
                ) {
                    Text("Cancel", color = MaterialTheme.colorScheme.onErrorContainer)
                }

                // Submit button
                Button(
                    onClick = {
                        if (voidReason.value.isNotBlank()) {
                            onSubmit(voidReason.value) // Trigger submit callback with the void reason
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Submit")
                }
            }
        }
    }
}
