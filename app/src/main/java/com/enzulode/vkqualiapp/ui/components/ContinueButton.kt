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
fun ContinueButton(
	modifier: Modifier = Modifier,
	status: Status = Status.Active,
	title: String = "Test",
	onTapped: () -> Unit = {},
	disabled: Boolean = false
) {

	val currentStatus = remember {
		mutableStateOf(Status.Inactive)
	}

	when (currentStatus.value) {
		Status.Inactive -> ContinueTopLevelStatusInactive(
			modifier = modifier
				.pointerInput(Unit)
				{
					detectTapGestures {
						if (!disabled)
						{
							currentStatus.value = Status.Active
							onTapped()
						}
					}
				}
		)
		{
			ContinueTitleStatusInactive(title = title)
		}
		Status.Active -> ContinueTopLevelStatusActive(
			modifier = modifier
				.pointerInput(Unit)
				{
					detectTapGestures {
						if (!disabled)
						{
							currentStatus.value = Status.Inactive
							onTapped()
						}
					}
				}
		)
		{
			ContinueTitleStatusActive(title = title)
		}
	}
}


@Composable
fun ContinueTitleStatusInactive(
	title: String,
	modifier: Modifier = Modifier
) {
	RelayText(
		content = title,
		fontSize = MaterialTheme.typography.button.fontSize,
		fontFamily = poppins,
		color = Color(
			alpha = 255,
			red = 255,
			green = 255,
			blue = 255
		),
		height = 1.1111111450195312.em,
		letterSpacing = (-0.3100000023841858).sp,
		fontWeight = MaterialTheme.typography.button.fontWeight,
		modifier = modifier.wrapContentHeight(align = Alignment.CenterVertically)
	)
}

@Composable
fun ContinueTopLevelStatusInactive(
	modifier: Modifier = Modifier,
	content: @Composable RelayContainerScope.() -> Unit
) {
	RelayContainer(
		backgroundColor = Color(
			alpha = 25,
			red = 255,
			green = 255,
			blue = 255
		),
		arrangement = RelayContainerArrangement.Row,
		padding = PaddingValues(
			start = 46.0.dp,
			top = 30.0.dp,
			end = 46.0.dp,
			bottom = 30.0.dp
		),
		itemSpacing = 10.0,
		clipToParent = false,
		radius = 74.0,
		content = content,
		modifier = modifier
	)
}


@Composable
fun ContinueTitleStatusActive(
	title: String,
	modifier: Modifier = Modifier
) {
	RelayText(
		content = title,
		fontSize = MaterialTheme.typography.button.fontSize,
		fontFamily = poppins,
		color = Color(
			alpha = 255,
			red = 0,
			green = 0,
			blue = 0
		),
		height = 1.1111111450195312.em,
		letterSpacing = (-0.3100000023841858).sp,
		fontWeight = MaterialTheme.typography.button.fontWeight,
		modifier = modifier.wrapContentHeight(align = Alignment.CenterVertically)
	)
}

@Composable
fun ContinueTopLevelStatusActive(
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
			start = 46.0.dp,
			top = 30.0.dp,
			end = 46.0.dp,
			bottom = 30.0.dp
		),
		itemSpacing = 10.0,
		clipToParent = false,
		radius = 74.0,
		content = content,
		modifier = modifier
	)
}