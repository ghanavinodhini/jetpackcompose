package com.example.jetpackcompose.shapes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.customTypography

@Composable
fun profileBoxShape(
    shape: Shape,
    width: Dp,
    height: Dp,
    color: Color
){
    Column(
        modifier = Modifier.fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center)
    ){
        Box(
            modifier = Modifier.size(width = width, height = height)
                                .clip(shape)
                                .background(color)
        ){
            Column(modifier = Modifier.fillMaxSize()
                                    .wrapContentSize(align = Alignment.Center)
            )
            {
                Box(
                    modifier = Modifier
                        .size(size = 100.dp)
                        .clip(shape = RoundedCornerShape(percent = 50))
                        .background(color = Color.Green)
                        .padding(top = 52.dp)
                ) {
                    /*Image(
                        painter = painterResource(id = R.drawable.splash_logo),
                        contentDescription = "avatar",
                        contentScale = ContentScale.Crop,            // crop the image if it's not a square
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)                       // clip to the circle shape
                            .border(2.dp, Color.Gray, CircleShape)   // add a border (optional)
                    )*/
                }
                    Text(
                        modifier = Modifier.padding(top = 24.dp, bottom = 12.dp),
                        text = "Welcome Olivia",
                        style = customTypography.button.copy(color = Color.White, fontSize = 14.sp)
                    )

            }

        }
    }

}