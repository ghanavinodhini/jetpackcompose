package com.example.jetpackcompose.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

//State hoisting inside viewmodel to avoid losing data during recomposition(rotating screen) and data persistency
class MyViewModel: ViewModel() {

    //state
    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")
    var addtasks by mutableStateOf("")

    //events
    fun onNameChanged(newName:String){
        name = newName
    }
    fun onEmailChanged(newEmail:String){
        email = newEmail
    }
    fun onPasswordChanged(newPassword:String){
        password = newPassword
    }
    fun onConfirmPasswordChanged(newConfirmPassword:String){
        confirmPassword = newConfirmPassword
    }
    fun onAddTasks(newTask:String){
        addtasks = newTask
    }

}