package de.syntax_institut.musicapp.data

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem<T: Any>(
    val title: String,
    val icon: ImageVector,
    val destination: T
)