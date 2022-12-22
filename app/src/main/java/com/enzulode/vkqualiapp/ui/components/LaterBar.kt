package com.enzulode.vkqualiapp.ui.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enzulode.vkqualiapp.laterbutton.LaterButton
import com.enzulode.vkqualiapp.laterbutton.Status

@Composable
fun LaterBar(text: String)
{

	val laterButton = remember {
		mutableStateOf(Status.Inactive)
	}

	Box(
		modifier = Modifier
			.fillMaxWidth()
			.padding(5.dp)
	)
	{
		Row(
			horizontalArrangement = Arrangement.SpaceBetween
		)
		{
			Column(
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally
			)
			{
				Box(contentAlignment = Alignment.Center)
				{
					Text(
						text = text,
						color = Color.DarkGray,
						modifier = Modifier
							.size(height = 60.dp, width = 260.dp)
							.padding(8.dp),
						fontSize = 16.sp
					)
				}
			}

			Column(
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.End
			)
			{
				Box(
					contentAlignment = Alignment.CenterEnd
				)
				{
					LaterButton(
						title = "Позже",
						status = laterButton.value,
						modifier = Modifier
							.padding(8.dp)
							.pointerInput(Unit) {
								detectTapGestures {
									if (laterButton.value == Status.Inactive)
										laterButton.value = Status.Active
									else
										laterButton.value = Status.Inactive
								}
							}
					)
				}
			}
		}
	}

}

@Preview
@Composable
fun previewBar()
{
	LaterBar(text = "Отметьте то, что Вам интересно, чтобы настроить Дзен")
}