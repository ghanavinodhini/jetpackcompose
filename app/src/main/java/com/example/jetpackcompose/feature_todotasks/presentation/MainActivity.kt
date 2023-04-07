package com.example.jetpackcompose.feature_todotasks.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.navigation.setupNavController
import com.example.jetpackcompose.viewmodel.MyViewModel

class MainActivity : ComponentActivity() {
    private val myViewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //setup nav controller
            setupNavController(rememberNavController())
        }
    }
}
