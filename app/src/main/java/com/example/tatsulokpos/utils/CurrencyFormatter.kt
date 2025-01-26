package com.example.tatsulokpos.utils

import androidx.compose.runtime.Composable
import java.text.NumberFormat
import java.util.Locale

@Composable
fun currencyFormatter(amount: Double): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("en", "PH")) // Locale for the Philippines
    return formatter.format(amount)
}
