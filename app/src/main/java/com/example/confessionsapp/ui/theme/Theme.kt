package com.example.confessionsapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = PurpleAccent,
    background = OffWhite,
    surface = Color.White,
    onPrimary = Color.White,
    onBackground = TextPrimary
)

@Composable
fun ConfessAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography(),
        content = content
    )
}