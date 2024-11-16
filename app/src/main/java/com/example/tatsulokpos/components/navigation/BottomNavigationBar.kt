package com.example.tatsulokpos.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Receipt
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tatsulokpos.components.navigation.data.BottomNavigation
import com.example.tatsulokpos.layout.POSLayout
import com.example.tatsulokpos.transactions.data.TransactionDao
import com.example.tatsulokpos.transactions.ui.TransactionsList


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

    Scaffold (
        bottomBar = { BottomNavigationBar(navController) } // Place BottomNavigationBar in the Scaffold
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "checkout",
            modifier = Modifier.padding(innerPadding) // Apply innerPadding to NavHost
        ) {
            composable("checkout") { POSLayout(navController) }
            composable("transactions") {
                TransactionsList(
                    transactionItems = TransactionDao.getTransactions(),
                    navController = navController
                )
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