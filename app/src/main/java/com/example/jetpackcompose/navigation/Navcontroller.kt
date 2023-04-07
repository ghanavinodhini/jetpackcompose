package com.example.jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcompose.homeScreen
import com.example.jetpackcompose.loginScreen
import com.example.jetpackcompose.onboardingScreen
import com.example.jetpackcompose.splashScreen
import com.example.jetpackcompose.viewmodel.MyViewModel

@Composable
fun setupNavController(controller: NavHostController){

    NavHost(navController = controller, startDestination = Screens.splashScreen.route){

        composable(Screens.splashScreen.route) {
          //showing splash screen
            splashScreen(navController = controller)
        }
        composable(Screens.onboardingScreen.route)  {
          //showing onboarding screen
            onboardingScreen(navController = controller, myViewModel = MyViewModel())
        }
        composable(Screens.loginScreen.route)  {
            //showing login screen
            loginScreen(navController = controller, myViewModel = MyViewModel())
        }
        composable(Screens.homeScreen.route)  {
            //showing home screen
            homeScreen(navController = controller, myViewModel = MyViewModel())
        }
    }
}