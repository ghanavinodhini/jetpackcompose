package com.example.jetpackcompose.feature_todotasks.presentation.todolist.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.feature_todotasks.domain.model.Todo

@Composable
fun TodoItem(
    todo: Todo,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    onCheckBoxClick: () -> Unit,
    onDeleteClick: () -> Unit
){

}