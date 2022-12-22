package com.enzulode.vkqualiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.enzulode.vkqualiapp.ui.components.ContinueBar
import com.enzulode.vkqualiapp.ui.components.LaterBar

class ChooseTopicsActivity : ComponentActivity()
{

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)

		setContent {

			Column(
				modifier = Modifier
					.background(Color.Black)
					.fillMaxSize(),
				horizontalAlignment = Alignment.CenterHorizontally
			)
			{
				LaterBar(text = "Отметьте то, что Вам интересно, чтобы настроить Дзен")
				ContinueBar()
			}

		}
	}

}