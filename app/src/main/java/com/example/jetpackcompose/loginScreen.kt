package com.example.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcompose.buttons.customButton
import com.example.jetpackcompose.navigation.Screens
import com.example.jetpackcompose.textfields.input
import com.example.jetpackcompose.textviews.captionText
import com.example.jetpackcompose.textviews.linkText
import com.example.jetpackcompose.ui.theme.BackgroundColor
import com.example.jetpackcompose.ui.theme.customTypography
import com.example.jetpackcompose.viewmodel.MyViewModel

@Composable
fun loginScreen(
    navController: NavController,
    myViewModel: MyViewModel
){
    Surface(
        color = BackgroundColor,
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                modifier = Modifier.padding(bottom = 30.dp),
                text = "Welcome back!",
                style = customTypography.h2,
            )
            captionText(
                modifier = Modifier.padding(bottom = 50.dp),
                caption = "Let’s help you meet your tasks"
            )
            Image(
                modifier = Modifier.padding(bottom = 100.dp),
                painter = painterResource(id = R.drawable.my_notifications_rjej_1),
                contentDescription = ""
            )
            input(
                placeholderText = "Enter Your Email",
                value = myViewModel.email,
                onValueChange = { myViewModel.onEmailChanged(it) }
            )
            input(
                placeholderText = "Enter Password",
                value = myViewModel.password,
                onValueChange = { myViewModel.onPasswordChanged(it) }
            )

            customButton(
                modifier = Modifier.padding(top = 300.dp),
                btnText = "Login",
                onClick = {
                    navController.navigate(Screens.homeScreen.route)
                }
            )
            Column(
                modifier = Modifier.fillMaxWidth().padding(top=20.dp),
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    /*captionText(
                        modifier = Modifier,
                        caption = "Don't have an account ? "
                    )*/
                    linkText(
                        caption = "Don't have an account ? ",
                        text = "Sign Up",
                        onClicked = {
                            navController.navigate(Screens.onboardingScreen.route)
                        }
                    )
                }

            }
        }
    }
}