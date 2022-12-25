package com.enzulode.vkqualiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.enzulode.vkqualiapp.ui.components.util.BoxScopeInstanceImpl.align

class FinalActivity : ComponentActivity()
{

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)

		setContent {
			Box(
				modifier = Modifier
					.fillMaxSize()
					.background(Color.Black)
					.align(Alignment.Center),
				contentAlignment = Alignment.Center
			)
			{
				Text(
					text = "Final page reached",
					fontSize = 20.sp,
					color = Color.White
				)
			}
		}
	}

}