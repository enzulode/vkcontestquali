package com.enzulode.vkqualiapp.ui.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.enzulode.vkqualiapp.ui.components.util.RelayContainer
import com.enzulode.vkqualiapp.ui.components.util.RelayContainerArrangement
import com.enzulode.vkqualiapp.ui.components.util.RelayContainerScope
import com.enzulode.vkqualiapp.ui.components.util.RelayText
import com.enzulode.vkqualiapp.ui.components.util.Status

@Composable
fun LaterButton(
	modifier: Modifier = Modifier,
	status: Status = Status.Inactive,
	title: String = "Text",
	onTapped: () -> Unit = {}
)
{

	val currentStatus = remember {
		mutableStateOf(Status.Inactive)
	}

	when (currentStatus.value)
	{
		Status.Inactive -> TopLevelStatusInactive(
			modifier = modifier
				.pointerInput(Unit)
				{
					detectTapGestures {
						currentStatus.value = Status.Active
						onTapped()
					}
				}
		)
		{
			TitleStatusInactive(title = title)
		}

		Status.Active -> TopLevelStatusActive(
			modifier = modifier
				.pointerInput(Unit)
				{
					detectTapGestures {
						currentStatus.value = Status.Inactive
						onTapped
					}
				}
		)
		{
			TitleStatusActive(title = title)
		}
	}

}

@Composable
fun TitleStatusInactive(
	title: String,
	modifier: Modifier = Modifier
)
{

	RelayText(
		content = title,
		fontSize = MaterialTheme.typography.button.fontSize,
		fontFamily = poppins,
		color = Color.White,
		height = 1.25.em,
		letterSpacing = (-0.3100000023841858).sp,
		fontWeight = MaterialTheme.typography.button.fontWeight,
		modifier = modifier.wrapContentHeight(align = Alignment.CenterVertically)
	)

}

@Composable
fun TopLevelStatusInactive(
	modifier: Modifier = Modifier,
	content: @Composable RelayContainerScope.() -> Unit
)
{

	RelayContainer(
		backgroundColor = Color(
			alpha = 30,
			red = 255,
			green = 255,
			blue = 255
		),
		arrangement = RelayContainerArrangement.Row,
		padding = PaddingValues(
			start = 28.0.dp,
			top = 10.0.dp,
			end = 28.0.dp,
			bottom = 10.0.dp
		),
		itemSpacing = 10.0,
		clipToParent = false,
		radius = 40.0,
		content = content,
		modifier = modifier
	)

}

@Composable
fun TitleStatusActive(
	title: String,
	modifier: Modifier = Modifier
) {
	RelayText(
		content = title,
		fontSize = MaterialTheme.typography.button.fontSize,
		fontFamily = poppins,
		color = Color.Black,
		height = 1.25.em,
		letterSpacing = (-0.3100000023841858).sp,
		fontWeight = MaterialTheme.typography.button.fontWeight,
		modifier = modifier.wrapContentHeight(align = Alignment.CenterVertically)
	)
}

@Composable
fun TopLevelStatusActive(
	modifier: Modifier = Modifier,
	content: @Composable RelayContainerScope.() -> Unit
) {
	RelayContainer(
		backgroundColor = Color(
			alpha = 255,
			red = 255,
			green = 255,
			blue = 255
		),
		arrangement = RelayContainerArrangement.Row,
		padding = PaddingValues(
			start = 28.0.dp,
			top = 10.0.dp,
			end = 28.0.dp,
			bottom = 10.0.dp
		),
		itemSpacing = 10.0,
		clipToParent = false,
		radius = 40.0,
		content = content,
		modifier = modifier
	)
}