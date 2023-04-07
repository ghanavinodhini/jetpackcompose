package com.example.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.buttons.customButton
import com.example.jetpackcompose.navigation.Screens
import com.example.jetpackcompose.textviews.captionText
import com.example.jetpackcompose.ui.theme.BackgroundColor
import com.example.jetpackcompose.ui.theme.customTypography
import com.example.jetpackcompose.ui.theme.showBars

@Composable
fun splashScreen(navController: NavController){

    showBars(false)

    Surface(
        color = BackgroundColor,
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(
                modifier = Modifier.padding(bottom = 100.dp),
                painter = painterResource(id = R.drawable.splash_logo),
                contentDescription = ""
            )
            Text(
                modifier = Modifier.padding(bottom = 30.dp),
                text = "Get things done with TODo",
                style = customTypography.h2,
            )
            captionText(
                modifier = Modifier.size(width = 242.dp, height = 49.dp),
                                //.padding(bottom = 350.dp),
                caption = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Amet."
            )
            customButton(
                modifier = Modifier.padding(top = 500.dp),
                btnText = "Get Started",
                onClick = {
                    navController.navigate(Screens.onboardingScreen.route)
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun show(){
    splashScreen(rememberNavController())
}