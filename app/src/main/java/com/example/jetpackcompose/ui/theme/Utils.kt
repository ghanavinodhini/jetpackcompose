package com.example.jetpackcompose.ui.theme

import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun showBars(flag:Boolean){
    rememberSystemUiController().apply {
        this.isSystemBarsVisible = flag
        this.isNavigationBarVisible = flag
        this.isStatusBarVisible = flag
    }
}