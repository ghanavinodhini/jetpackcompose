package com.example.jetpackcompose.buttons

import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.ButtonBg
import com.example.jetpackcompose.ui.theme.customTypography

@Composable
fun customButton(
    modifier: Modifier,
     btnText: String,
     onClick: () -> Unit
){
        Button(
            shape = RectangleShape,
            modifier = Modifier
                .size(width = 310.dp, height = 60.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = ButtonBg),
            onClick = onClick
        ) {
            Text(
                text = btnText,
                textAlign = TextAlign.Center,
                style = customTypography.button,
            )
        }
}

