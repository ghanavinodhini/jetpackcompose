package com.example.jetpackcompose.feature_todotasks.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    val todo: String,
    val time: String,
    val isComplete: Boolean,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
) {
}

class InvalidTodoException(message:String) : Exception(message)
