package com.example.tatsulokpos.transactions.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavHostController
import com.example.tatsulokpos.transactions.model.TransactionModel
import com.example.tatsulokpos.utils.currencyFormatter

@Composable
fun TransactionsList(
    transactionItems: List<TransactionModel>,
    onVoidClick: (TransactionModel) -> Unit // Callback for void button
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Transactions",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (transactionItems.isEmpty()) {
            Text("No transactions found", style = MaterialTheme.typography.bodyMedium)
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(transactionItems.size) { index ->
                    TransactionCard(
                        transaction = transactionItems[index],
                        onVoidClick = onVoidClick
                    )
                }
            }
        }
    }
}



@Composable
fun TransactionCard(
    transaction: TransactionModel,
    onVoidClick: (TransactionModel) -> Unit // Callback for Void button
) {
    Box(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Transaction ID: ${transaction.transaction_id}",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                    Text(
                        text = "Product ID: ${transaction.product_id}",
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
                    )
                }
                Text(
                    text = currencyFormatter(transaction.amount),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.secondary
                    )
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Date: ${transaction.transaction_date}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Type: ${transaction.transaction_type}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Remarks: ${transaction.remarks}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Text(
                    text = "Quantity: ${transaction.quantity}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            // Void Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Void Transaction",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Transparent)
                        .padding(8.dp)
                        .clickable { onVoidClick(transaction) }
                )
            }
        }
    }
}

