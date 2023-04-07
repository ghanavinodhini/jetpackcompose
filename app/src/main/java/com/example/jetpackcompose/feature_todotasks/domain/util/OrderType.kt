package com.example.jetpackcompose.feature_todotasks.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
