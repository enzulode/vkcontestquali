package com.enzulode.vkqualiapp.ui.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enzulode.vkqualiapp.continuebutton.ContinueButton
import com.enzulode.vkqualiapp.continuebutton.Status

@Preview
@Composable
fun ContinueBar()
{

	val continueButtonMode = remember {
		mutableStateOf(Status.Inactive)
	}

	Row(
		horizontalArrangement = Arrangement.Center,
		verticalAlignment = Alignment.CenterVertically,
		modifier = Modifier.fillMaxWidth().padding(5.dp)
	)
	{

		ContinueButton(
			title = "Продолжить",
			status = continueButtonMode.value,
			modifier = Modifier
				.padding(8.dp)
				.pointerInput(Unit)
				{
					detectTapGestures {
						if (continueButtonMode.value == Status.Inactive)
							continueButtonMode.value = Status.Active
						else
							continueButtonMode.value = Status.Inactive
					}
				}
		)

	}

}