package com.example.jetpackcompose.feature_todotasks.presentation.todolist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.feature_todotasks.data.data_source.room.TodoDao
import com.example.jetpackcompose.feature_todotasks.domain.model.Todo
import com.example.jetpackcompose.feature_todotasks.domain.use_case.TodoUseCases
import com.example.jetpackcompose.feature_todotasks.domain.util.OrderType
import com.example.jetpackcompose.feature_todotasks.domain.util.TodoOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    //private val todoDao: TodoDao //Inject dao
    private val todoUseCases: TodoUseCases
) : ViewModel() {

    private val _state = mutableStateOf(TodoState())
    val state: State<TodoState> = _state

    private var recentlyDeletedTask: Todo? = null

    private var getTasksJob : Job? = null

    init {
        getTasks(TodoOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: TodoEvent){
        when(event){
            is TodoEvent.Order -> {
                if(state.value.todoOrder::class == event.todoOrder::class &&
                        state.value.todoOrder.orderType == event.todoOrder.orderType
                ){
                    return
                }
                getTasks(event.todoOrder)
            }
            is TodoEvent.DeleteTask -> {
                viewModelScope.launch {
                    todoUseCases.deleteTask(event.todo)
                    recentlyDeletedTask = event.todo
                }

            }
            is TodoEvent.RestoreTodo -> {
                viewModelScope.launch {
                    todoUseCases.addTask(recentlyDeletedTask ?: return@launch)
                    recentlyDeletedTask = null
                }

            }
            is TodoEvent.ToggleDoneTask -> {
                _state.value = state.value.copy(
                    isTaskDone = !state.value.isTaskDone
                )
            }
        }
    }

    private fun getTasks(todoOrder: TodoOrder){
        getTasksJob?.cancel()
        getTasksJob = todoUseCases.getTasks(todoOrder)
            .onEach { tasks ->
                _state.value = state.value.copy(
                    tasks = tasks,
                    todoOrder = todoOrder
                )
            }
            .launchIn(viewModelScope)
    }

}