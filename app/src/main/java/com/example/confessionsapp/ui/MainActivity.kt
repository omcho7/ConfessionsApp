package com.example.confessionsapp.ui

import MainScreenWithBottomBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.confessionsapp.ui.theme.ConfessAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfessAppTheme {
                val navController = rememberNavController()
                MainScreenWithBottomBar(navController)
            }
        }
    }
}