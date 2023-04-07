package com.example.jetpackcompose.shapes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.customTypography

@Composable
fun tasksBox(
    text: String
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Box {
            Text(
                modifier = Modifier
                    .padding(top = 8.dp, start = 24.dp),
                text = text,
                style = customTypography.caption.copy(color = Color.Black)
            )
        }
        tasksListBoxShape()
    }
}