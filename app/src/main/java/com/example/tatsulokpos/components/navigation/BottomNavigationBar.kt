package com.example.tatsulokpos.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Receipt
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tatsulokpos.components.navigation.data.BottomNavigation


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

@Preview(showBackground = true, widthDp = 1024, heightDp = 768)
@Composable
fun BottomNavigationBar() {
    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            navItems.forEach { item ->
                NavigationBarItem(
                    selected = item.route == "checkout",
                    onClick = {},
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