package com.example.jetpackcompose.textviews

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.example.jetpackcompose.buttons.NoRippleInteractionSource
import com.example.jetpackcompose.ui.theme.ParaText
import com.example.jetpackcompose.ui.theme.linkTextColor


/*@Composable*/
/*fun linkText(*/
/*   modifier: Modifier,*/
/*    linkText: String,*/
/*    onClick: () -> Unit*/
/*){*/
        /*ClickableText(
            text = AnnotatedString(linkText),
            onClick = onClick,
            style = customTypography.caption,
        )*/
/*    TextButton(*/
/*              onClick = onClick*/
/*    ){*/
/*        Text(*/
/*             text = linkText,*/
/*            style = customTypography.caption*/
/*        )*/
/*    }*/
/*}*/


@Composable
fun linkText(
    caption:String,
    text:String,
    onClicked: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        //append your initial text
        withStyle(
            style = SpanStyle(
                color = ParaText,
            )
        ) {
            //append("Don't have an account ? ")
            append(caption)

        }

        //Start of the pushing annotation which you want to color and make them clickable later
        pushStringAnnotation(

/*tag = "Sign Up",// provide tag which will then be provided when you click the text
            annotation = "Sign Up"*/


            tag = text,// provide tag which will then be provided when you click the text
            annotation = text
        )
        //add text with your different color/style
        withStyle(
            style = SpanStyle(
                color = linkTextColor,
            )
        ) {
            //append("Sign Up")
            append(text)
        }
        // when pop is called it means the end of annotation with current tag
        pop()
    }

   /* ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(
               // tag = "Sign Up",// tag which you used in the buildAnnotatedString
                tag = text,
                start = offset,
                end = offset
            ).firstOrNull()?.let { annotation ->
                //do your stuff when it gets clicked
                Log.d("Clicked", annotation.item)
                onClicked
            }
        }
    )  */

    TextButton(
        onClick = onClicked,
        interactionSource = NoRippleInteractionSource()
    ) {
        Text(
            text = annotatedText
        )
    }
}
