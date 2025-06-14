package com.starbucks.clone.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = StarbucksGreen,
    onPrimary = White,
    primaryContainer = StarbucksLightGreen,
    onPrimaryContainer = StarbucksDarkGreen,
    secondary = StarbucksGold,
    onSecondary = Black,
    secondaryContainer = YellowGradient,
    onSecondaryContainer = StarbucksDarkGold,
    tertiary = OrangeGradientStart,
    onTertiary = White,
    background = White,
    onBackground = Black,
    surface = White,
    onSurface = Black,
    surfaceVariant = LightGray,
    onSurfaceVariant = DarkGray,
    outline = MediumGray
)

private val DarkColorScheme = darkColorScheme(
    primary = StarbucksLightGreen,
    onPrimary = StarbucksDarkGreen,
    primaryContainer = StarbucksDarkGreen,
    onPrimaryContainer = StarbucksLightGreen,
    secondary = StarbucksGold,
    onSecondary = Black,
    secondaryContainer = StarbucksDarkGold,
    onSecondaryContainer = YellowGradient,
    tertiary = OrangeGradientEnd,
    onTertiary = White,
    background = Black,
    onBackground = White,
    surface = DarkGray,
    onSurface = White,
    surfaceVariant = DarkGray,
    onSurfaceVariant = LightGray,
    outline = MediumGray
)

@Composable
fun StarbucksCloneTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

