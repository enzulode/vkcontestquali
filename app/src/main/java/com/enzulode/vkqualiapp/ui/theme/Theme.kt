package com.enzulode.vkqualiapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
	primary = DarkPrimaryColor,
	secondary = DarkSecondaryColor,
	background = DarkBackgroundColor,
	surface = DarkSurfaceColor
)

private val LightColorPalette = lightColors(
	primary = DefaultTextColor,
	primaryVariant = Color.Black,
	secondary = SecondaryTextColor,
	background = Color.Black,
	surface = Color.Black

	/* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun VkQualiAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit)
{
//	val colors = if (darkTheme)
//	{
//		DarkColorPalette
//	} else
//	{
//		LightColorPalette
//	}

	val colors = DarkColorPalette

	MaterialTheme(
		colors = colors,
		typography = Typography,
		shapes = Shapes,
		content = content
	)
}