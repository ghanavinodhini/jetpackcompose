package com.example.jetpackcompose.shapes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.dialogs.AddTaskDialog
import com.example.jetpackcompose.viewmodel.MyViewModel

@Composable
fun tasksListBoxShape(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp, start = 24.dp, end = 25.dp)
    ) {
        var openDialog by remember {
            mutableStateOf(false) // Initially dialog is closed
        }
        Box(
            modifier = Modifier
                //.size(width = 310.dp, height = 170.dp)
                .clip(shape = RoundedCornerShape(size = 15f))
                .background(Color.White)
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Daily Tasks",
                    textAlign = TextAlign.Start
                )
               Image(
                   painter = painterResource(id = R.drawable.plus_circle),
                   contentDescription = null,
                   modifier = Modifier
                       .clickable
                       {
                            println("Button Clicked!")
                           openDialog = true
                       }
                    )
                if (openDialog){
                    AddTaskDialog(
                        myViewModel = MyViewModel(),
                        onDismiss = {openDialog = false}
                    )
                    //{
                        //openDialog = false
                    //}
                }
            }
        }
    }
}