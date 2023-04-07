package com.example.jetpackcompose.feature_todotasks.domain.util

sealed class TodoOrder(val orderType: OrderType){
    class Title(orderType: OrderType) : TodoOrder(orderType)
    class Date(orderType: OrderType) : TodoOrder(orderType)
}
