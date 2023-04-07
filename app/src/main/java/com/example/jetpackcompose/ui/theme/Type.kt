package com.example.jetpackcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R

// Declare variable for custom fonts added
val poppins = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_semibold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /*buttonFont = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.SemiBold,
        color = ButtonTextWhite,
        fontSize = 18.sp
    )*/
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val customTypography = Typography(
    button = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.SemiBold,
        color = ButtonTextWhite,
        fontSize = 18.sp
    ),
    caption = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Normal,
        color = ParaText,
        fontSize = 13.sp
    ),
    h2 = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.SemiBold,
        color = HeadingTextColor,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Normal,
        color = linkTextColor,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Medium,
        color = HeadingTextColor,
        fontSize = 13.sp
    ),
)


