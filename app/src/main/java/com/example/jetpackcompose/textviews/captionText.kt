package com.example.jetpackcompose.textviews

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.jetpackcompose.ui.theme.customTypography

@Composable
fun captionText(
    modifier: Modifier,
    caption: String
){
    Text(
        modifier = modifier,
            //.size(width = 242.dp, height = 49.dp),
        text = caption,
        textAlign = TextAlign.Center,
        style = customTypography.caption
    )
}