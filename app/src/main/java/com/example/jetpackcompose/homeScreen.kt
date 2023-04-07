package com.example.jetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcompose.shapes.clockBox
import com.example.jetpackcompose.shapes.profileBoxShape
import com.example.jetpackcompose.shapes.tasksBox
import com.example.jetpackcompose.ui.theme.BackgroundColor
import com.example.jetpackcompose.ui.theme.profileRectangleColor
import com.example.jetpackcompose.viewmodel.MyViewModel

@Composable
fun homeScreen(
    navController: NavController,
    myViewModel: MyViewModel
){
    Surface(
        color = BackgroundColor,
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            profileBoxShape(
                shape = RectangleShape,
                width = 360.dp,
                height = 229.dp,
                color = profileRectangleColor
            )
            clockBox(
                text = "Good afternoon"
            )
            tasksBox(
                text = "Tasks List"
            )
        }
    }
}