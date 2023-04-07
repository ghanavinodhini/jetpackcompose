package com.example.jetpackcompose.feature_todotasks.domain.use_case

data class TodoUseCases(
    val getTasks: GetTasks,
    val deleteTask: DeleteTask,
    val addTask: AddTask
)
