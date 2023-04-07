package com.example.jetpackcompose.dialogs

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcompose.R
import com.example.jetpackcompose.textfields.addTaskInput
import com.example.jetpackcompose.ui.theme.BackgroundColor
import com.example.jetpackcompose.ui.theme.customTypography
import com.example.jetpackcompose.viewmodel.MyViewModel

@Composable
fun AddTaskDialog(
    myViewModel: MyViewModel,
    onDismiss : () -> Unit,
){
    Dialog(
        onDismissRequest = onDismiss
    ){
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = 4.dp,
            color = BackgroundColor
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(228.dp)
                ){
                    Text(
                        modifier = Modifier
                            .padding(top = 25.dp, start = 25.dp),
                        text = "Add Task",
                        style = customTypography.caption.copy(color = Color.Black)
                    )

                    Box (
                        modifier = Modifier
                            .padding(top = 69.dp, start = 24.dp, end = 26.dp)
                    )
                    {
                        addTaskInput(
                            placeholderText = "Enter Task Description",
                            value = myViewModel.addtasks,
                            onValueChange = { myViewModel.onAddTasks(it) }
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 189.dp, start = 24.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.timer),
                            contentDescription = "",
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 189.dp, end = 17.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.send),
                            contentDescription = "",
                        )
                    }
                }
            }
        }
    }
}