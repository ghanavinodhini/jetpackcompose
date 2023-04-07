package com.example.jetpackcompose.shapes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.customTypography

@Composable
fun clockBox(
    text : String
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.End)
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 10.dp, end = 25.dp),
                text = text,
                style = customTypography.caption.copy(color = Color.Black)
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ){
           /* Image(
                modifier = Modifier.padding(top = 25.dp),
                painter = painterResource(id = R.drawable.clock),
                contentDescription = ""
            )*/
        }
    }
}
