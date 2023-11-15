package com.nikolaej.cacademy.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nikolaej.cacademy.R

private val Comfortaa = FontFamily(
    Font(R.font.comfortaa_bold, FontWeight.W600),
    Font(R.font.comfortaa_light, FontWeight.W300),
    Font(R.font.comfortaa_medium, FontWeight.W400),
    Font(R.font.comfortaa_regular, FontWeight.W500)
)


val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Comfortaa,
        fontWeight = FontWeight.W600,
        fontSize = 25.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Comfortaa,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Comfortaa,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = Comfortaa,
        fontWeight = FontWeight.W600,
        fontSize = 25.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Comfortaa,
        fontWeight = FontWeight.W500,
        fontSize = 22.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Comfortaa,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Comfortaa,
        fontWeight = FontWeight.W500,
        fontSize = 25.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Comfortaa,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Comfortaa,
        fontWeight = FontWeight.W400,
        fontSize = 17.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Comfortaa,
        fontWeight = FontWeight.W400,
        fontSize = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Comfortaa,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Comfortaa,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),

)