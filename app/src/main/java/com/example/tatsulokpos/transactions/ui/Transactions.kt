package com.example.tatsulokpos.transactions.ui

import androidx.compose.foundation.background
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
fun TransactionsList(transactionItems: List<TransactionModel>, navController: NavHostController) {
    Column (
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Transactions", style = MaterialTheme.typography.headlineLarge)

        if(transactionItems.isEmpty()) {
            Text("No transactions found")
        } else {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)  // Restrict the height to available space only
                    .padding(bottom = 16.dp)  // Add extra padding to stop behind total section
            ) {
                items(transactionItems.size) { index ->
                    TransactionCard(index, transactionItems)
                }
            }
        }
    }
}


@Composable
fun TransactionCard(index: Int, transactionItems: List<TransactionModel>) {
    val transactionItem = transactionItems[index]

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
                text = transactionItem.id.toString(),
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
                    Text(
                        text = transactionItem.date,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )

                }
                Text(
                    text = currencyFormatter(transactionItem.total),
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