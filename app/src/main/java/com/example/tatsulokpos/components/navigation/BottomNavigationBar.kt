package com.example.tatsulokpos.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Receipt
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tatsulokpos.components.navigation.data.BottomNavigation
import com.example.tatsulokpos.layout.POSLayout
import com.example.tatsulokpos.transactions.model.TransactionModel
import com.example.tatsulokpos.transactions.ui.TransactionsList
import com.example.tatsulokpos.transactions.ui.VoidTransactionModal
import com.example.tatsulokpos.transactions.viewmodel.TransactionViewModel

val navItems = listOf(
    BottomNavigation(
        name = "Checkout",
        route = "checkout",
        icon = Icons.Rounded.ShoppingCart
    ),
    BottomNavigation(
        name = "Transactions",
        route = "transactions",
        icon = Icons.Rounded.Receipt
    ),
    BottomNavigation(
        name = "Notifications",
        route = "notifications",
        icon = Icons.Rounded.Notifications
    ),
    BottomNavigation(
        name = "More",
        route = "more",
        icon = Icons.Rounded.Menu
    )
)

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    val transactionViewModel: TransactionViewModel = viewModel()

    // State to manage modal visibility and selected transaction
    var showVoidModal by remember { mutableStateOf(false) }
    var selectedTransaction by remember { mutableStateOf<TransactionModel?>(null) }

    // Fetch transactions when the component is displayed
    LaunchedEffect(Unit) {
        transactionViewModel.fetchAllTransactions()
    }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "checkout",
            modifier = Modifier.padding(innerPadding)
        ) {
            // Checkout Screen
            composable("checkout") { POSLayout(navController) }

            // Transactions Screen
            composable("transactions") {
                val transactions by transactionViewModel.transactions.collectAsState()

                TransactionsList(
                    transactionItems = transactions,
                    onVoidClick = { transaction ->
                        selectedTransaction = transaction // Set the selected transaction
                        showVoidModal = true // Show the modal
                    }
                )

                // Modal for Void Transaction
                if (showVoidModal) {
                    VoidTransactionModal(
                        transaction = selectedTransaction,
                        onDismiss = { showVoidModal = false },
                        onSubmit = { reason ->
                            // Void the transaction using ViewModel
                            selectedTransaction?.let {
                                transactionViewModel.voidTransaction(it.transaction_id, reason)
                            }
                            showVoidModal = false
                        }
                    )
                }
            }

            // Notifications Screen (Placeholder)
            composable("notifications") {
                Text("Notifications Screen", modifier = Modifier.padding(16.dp))
            }

            // More Screen (Placeholder)
            composable("more") {
                Text("More Screen", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            navItems.forEach { item ->
                NavigationBarItem(
                    selected = item.route == navController.currentDestination?.route,
                    onClick = { navController.navigate(item.route) },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = item.name,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                )
            }
        }
    }
}
