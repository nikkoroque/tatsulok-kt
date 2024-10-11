package com.example.tatsulokpos.components.navigation.data

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigation(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int? = null
)
