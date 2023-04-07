package com.example.jetpackcompose.feature_todotasks.presentation.todolist.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.feature_todotasks.domain.util.OrderType
import com.example.jetpackcompose.feature_todotasks.domain.util.TodoOrder

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    todoOrder: TodoOrder = TodoOrder.Date(OrderType.Descending),
    onOrderChange: (TodoOrder) -> Unit
){
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            DefaultCheckBox(
                todoText = "Title",
                checked = todoOrder is TodoOrder.Title,
                onCheck = {onOrderChange(TodoOrder.Title(todoOrder.orderType))}
            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultCheckBox(
                todoText = "Date",
                checked = todoOrder is TodoOrder.Date,
                onCheck = {onOrderChange(TodoOrder.Date(todoOrder.orderType))}
            )
        }
    }
}