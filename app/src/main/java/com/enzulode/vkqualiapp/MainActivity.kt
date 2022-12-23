package com.enzulode.vkqualiapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import com.enzulode.vkqualiapp.laterbutton.LaterButton
import com.enzulode.vkqualiapp.laterbutton.Status
import com.enzulode.vkqualiapp.ui.theme.VkQualiAppTheme

class MainActivity : ComponentActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContent {

			MainActivityContent()

		}
	}

	@Composable
	private fun MainActivityContent()
	{
		val laterButtonState = remember {
			mutableStateOf(Status.Inactive)
		}

		VkQualiAppTheme()
		{
			Row(
				modifier = Modifier
					.fillMaxSize()
					.background(Color.Black)
				,
				horizontalArrangement = Arrangement.SpaceAround,
				verticalAlignment = Alignment.CenterVertically
			)
			{
				LaterButton(
					title = "Далее",
					status = laterButtonState.value,
					modifier = Modifier.pointerInput(Unit)
					{
						detectTapGestures {
							val intent = Intent(this@MainActivity, ChooseTopicsActivity::class.java)
							startActivity(intent)
						}
					}
				)
			}
		}
	}
}