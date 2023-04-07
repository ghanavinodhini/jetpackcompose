package com.example.jetpackcompose.textfields

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.customTypography

@Composable
fun addTaskInput(
    placeholderText:String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    value: String,
    onValueChange : (String) -> Unit
){
    OutlinedTextField(
        modifier = Modifier
            //.align(alignment = Alignment.CenterStart)
            //.padding(start = 50.dp)
            .size(width = 325.dp, height = 43.dp),
        //.clip(shape = RoundedCornerShape(size = 80f)),
        value = value,
        onValueChange =  onValueChange,
        label = {
            Text(
                modifier = Modifier
                    .padding(start = 16.dp),
                text = placeholderText,
                style = customTypography.body2
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent),
        shape = RoundedCornerShape(size = 4f),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions
    )
}