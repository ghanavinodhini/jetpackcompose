package com.example.jetpackcompose.navigation

sealed class Screens(val route:String){

    object splashScreen : Screens("Splash Screen")
    object onboardingScreen : Screens("Onboarding Screen")
    object loginScreen : Screens("Login Screen")
    object homeScreen : Screens("Home Screen")

}