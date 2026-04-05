package com.example.lab23.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

val AltLightColorScheme = lightColorScheme(
    primary = Color(0xFF0061A4),
    secondary = Color(0xFF535F70),
    background = Color(0xFFFDFBFF)
)

val AltDarkColorScheme = darkColorScheme(
    primary = Color(0xFFD1E4FF),
    secondary = Color(0xFFBBC7DB),
    background = Color(0xFF1A1C1E)
)
@Composable
fun Lab23Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colorStyle: Int = 1,
    content: @Composable () -> Unit
) {
    val colorScheme = when (colorStyle) {
        1 -> if (darkTheme) DarkColorScheme else LightColorScheme
        2 -> if (darkTheme) AltDarkColorScheme else AltLightColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}