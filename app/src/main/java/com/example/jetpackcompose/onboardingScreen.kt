package com.example.jetpackcompose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.buttons.customButton
import com.example.jetpackcompose.navigation.Screens
import com.example.jetpackcompose.textfields.input
import com.example.jetpackcompose.textviews.captionText
import com.example.jetpackcompose.textviews.linkText
import com.example.jetpackcompose.ui.theme.BackgroundColor
import com.example.jetpackcompose.ui.theme.customTypography
import com.example.jetpackcompose.ui.theme.showBars
import com.example.jetpackcompose.viewmodel.MyViewModel

@Composable
fun onboardingScreen(
    navController: NavController,
    myViewModel: MyViewModel
){
    showBars(true)

    Surface(
        color = BackgroundColor,
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //Commented -- Use ViewModel state instead of State hoisting
           /* val (name, setName) = remember { mutableStateOf("") }*/
           /* val (email, setEmail) = remember { mutableStateOf("") }*/
           /* val (password, setPassword) = remember { mutableStateOf("") }*/
           /* val (confirmPassword, setConfirmPassword) = remember { mutableStateOf("") }*/

            Text(
                modifier = Modifier.padding(bottom = 30.dp),
                text = "Welcome Onboard!",
                style = customTypography.h2,
            )
            captionText(
                 modifier = Modifier.padding(bottom = 50.dp),
                caption = "Let’s help you meet your tasks"
            )
            input(
                placeholderText = "Enter Your Full Name",
                value = myViewModel.name,
                onValueChange = { myViewModel.onNameChanged(it) }
            )
            input(
                placeholderText = "Enter Your Email",
                value = myViewModel.email,
                onValueChange = { myViewModel.onEmailChanged(it) }
            )
            input(
                placeholderText = "Enter Password",
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                value = myViewModel.password,
                onValueChange = { myViewModel.onPasswordChanged(it) }
            )
            input(
                placeholderText = "Confirm Password",
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                value = myViewModel.confirmPassword,
                onValueChange = { myViewModel.onConfirmPasswordChanged(it) }
            )
            customButton(
                modifier = Modifier.padding(top = 300.dp),
                btnText = "Register",
                onClick = {}
            )
            Column(
                modifier = Modifier.fillMaxWidth().padding(top=20.dp),
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    /*captionText(*/
                    /*    modifier = Modifier,*/
                    /*    caption = "Already have an account ? "*/
                    /*)*/
                    linkText(
                       // modifier = Modifier,
                        caption = "Already have an account ? ",
                        text = "Sign In",
                        onClicked = {
                             navController.navigate(Screens.loginScreen.route)
                        }
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun show(){
    onboardingScreen(rememberNavController(), myViewModel = MyViewModel())
}