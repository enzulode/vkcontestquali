package com.enzulode.vkqualiapp.ui.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.enzulode.vkqualiapp.R
import com.enzulode.vkqualiapp.ui.components.util.Status
import com.enzulode.vkqualiapp.ui.components.util.*
import com.enzulode.vkqualiapp.ui.components.util.CrossAxisAlignment

@Composable
fun TopicChirp(
	modifier: Modifier = Modifier,
	status: Status = Status.Inactive,
	title: String = "Test",
	onTapped: () -> Unit = {}
)
{
	val currentState =  remember {
		mutableStateOf(status)
	}

	when (currentState.value) {
		Status.Inactive -> TopicChirpTopLevelStatusInactive(
			onTapped = {
				currentState.value = Status.Active
				onTapped()
			},
			modifier = modifier
		)
		{

			TopicChirpTextLayoutStatusInactive {
				TopicChirpTitleStatusInactive(title = title)
			}

			TopicChirpRightStatusInactive {
				TopicChirpDividerStatusInactive()
				TopicChirpClass24PlusStatusInactive {
					TopicChirpIconStatusInactive(
						modifier = Modifier
							.rowWeight(1.0f)
							.columnWeight(1.0f))
				}
			}
		}

		Status.Active -> TopicChirpTopLevelStatusActive(
			onTapped = {
				currentState.value = Status.Inactive
				onTapped()
			},
			modifier = modifier
		)
		{

			TopicChirpTextLayoutStatusActive {
				TopicChirpTitleStatusActive(title = title)
			}

			TopicChirpRightStatusActive {
				TopicChirpDividerStatusActive()
				TopicChirpClass24CheckStatusActive {
					TopicChirpIconStatusActive(
						modifier = Modifier
							.rowWeight(1.0f)
							.columnWeight(1.0f)
					)
				}
			}

		}
	}

}

//Inactive functions

@Composable
fun TopicChirpTopLevelStatusInactive(
	onTapped: () -> Unit,
	modifier: Modifier = Modifier,
	content: @Composable RelayContainerScope.() -> Unit
)
{
	RelayContainer(
		backgroundColor = Color(
			alpha = 43,
			red = 255,
			green = 255,
			blue = 255
		),
		arrangement = RelayContainerArrangement.Row,
		padding = PaddingValues(
			start = 12.0.dp,
			top = 8.0.dp,
			end = 8.0.dp,
			bottom = 8.0.dp
		),
		itemSpacing = 6.0,
		clipToParent = false,
		radius = 12.0,
		borderAlignment = BorderAlignment.Center,
		content = content,
		modifier = modifier
			.pointerInput(Unit)
			{
				detectTapGestures {
					onTapped()
				}
			}
	)
}

@Composable
fun TopicChirpTitleStatusInactive(
	title: String,
	modifier: Modifier = Modifier
)
{
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
		height = 1.25.em,
		letterSpacing = (-0.3100000023841858).sp,
		textAlign = TextAlign.Left,
		fontWeight = MaterialTheme.typography.button.fontWeight,
		modifier = modifier
	)
}

@Composable
fun TopicChirpTextLayoutStatusInactive(
	modifier: Modifier = Modifier,
	content: @Composable RelayContainerScope.() -> Unit
)
{

	RelayContainer(
		mainAxisAlignment = MainAxisAlignment.Start,
		crossAxisAlignment = CrossAxisAlignment.Start,
		arrangement = RelayContainerArrangement.Row,
		padding = PaddingValues(
			start = 0.0.dp,
			top = 1.0.dp,
			end = 0.0.dp,
			bottom = 3.0.dp
		),
		clipToParent = false,
		content = content,
		modifier = modifier
	)

}

@Composable
fun TopicChirpRightStatusInactive(
	modifier: Modifier = Modifier,
	content: @Composable RelayContainerScope.() -> Unit
)
{

	RelayContainer(
		mainAxisAlignment = MainAxisAlignment.Start,
		arrangement = RelayContainerArrangement.Row,
		padding = PaddingValues(
			start = 8.0.dp,
			top = 0.0.dp,
			end = 0.0.dp,
			bottom = 0.0.dp
		),
		itemSpacing = 8.0,
		clipToParent = false,
		content = content,
		modifier = modifier
	)

}

@Composable
fun TopicChirpDividerStatusInactive(
	modifier: Modifier = Modifier
)
{
	RelayVector(
		vector = painterResource(R.drawable.topic_chirp_divider),
		modifier = modifier
			.requiredWidth(1.0.dp)
			.requiredHeight(20.0.dp)
	)
}

@Composable
fun TopicChirpClass24PlusStatusInactive(
	modifier: Modifier = Modifier,
	content: @Composable RelayContainerScope.() -> Unit
)
{
	RelayContainer(
		isStructured = false,
		clipToParent = false,
		content = content,
		modifier = modifier
			.requiredWidth(24.0.dp)
			.requiredHeight(24.0.dp)
	)
}

@Composable
fun TopicChirpIconStatusInactive(
	modifier: Modifier = Modifier
)
{
	RelayVector(
		vector = painterResource(R.drawable.topic_chirp_icon),
		modifier = modifier
			.padding(paddingValues = PaddingValues(all = 3.0.dp))
			.fillMaxWidth(1.0f)
			.fillMaxHeight(1.0f)
	)
}

// Active functions

@Composable
fun TopicChirpTopLevelStatusActive(
	onTapped: () -> Unit,
	modifier: Modifier = Modifier,
	content: @Composable RelayContainerScope.() -> Unit
)
{
	RelayContainer(
		backgroundColor = Color(
			alpha = 255,
			red = 255,
			green = 83,
			blue = 23
		),
		arrangement = RelayContainerArrangement.Row,
		padding = PaddingValues(
			start = 12.0.dp,
			top = 8.0.dp,
			end = 8.0.dp,
			bottom = 8.0.dp
		),
		itemSpacing = 6.0,
		clipToParent = false,
		radius = 12.0,
		borderAlignment = BorderAlignment.Center,
		content = content,
		modifier = modifier.tappable(onTap = onTapped)
	)
}

@Composable
fun TopicChirpTextLayoutStatusActive(
	modifier: Modifier = Modifier,
	content: @Composable RelayContainerScope.() -> Unit
)
{
	RelayContainer(
		mainAxisAlignment = MainAxisAlignment.Start,
		crossAxisAlignment = CrossAxisAlignment.Start,
		arrangement = RelayContainerArrangement.Row,
		padding = PaddingValues(
			start = 0.0.dp,
			top = 1.0.dp,
			end = 0.0.dp,
			bottom = 3.0.dp
		),
		clipToParent = false,
		content = content,
		modifier = modifier
	)
}

@Composable
fun TopicChirpTitleStatusActive(
	title: String,
	modifier: Modifier = Modifier
)
{
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
		height = 1.25.em,
		letterSpacing = (-0.3100000023841858).sp,
		textAlign = TextAlign.Left,
		fontWeight = MaterialTheme.typography.button.fontWeight,
		modifier = modifier
	)
}

@Composable
fun TopicChirpRightStatusActive(
	modifier: Modifier = Modifier,
	content: @Composable RelayContainerScope.() -> Unit
)
{
	RelayContainer(
		mainAxisAlignment = MainAxisAlignment.Start,
		arrangement = RelayContainerArrangement.Row,
		padding = PaddingValues(
			start = 8.0.dp,
			top = 0.0.dp,
			end = 0.0.dp,
			bottom = 0.0.dp
		),
		itemSpacing = 8.0,
		clipToParent = false,
		content = content,
		modifier = modifier
	)
}

@Composable
fun TopicChirpDividerStatusActive(
	modifier: Modifier = Modifier
)
{
	RelayVector(modifier = modifier
		.requiredWidth(1.0.dp)
		.requiredHeight(20.0.dp))
}

@Composable
fun TopicChirpClass24CheckStatusActive(
	modifier: Modifier = Modifier,
	content: @Composable RelayContainerScope.() -> Unit
)
{
	RelayContainer(
		isStructured = false,
		clipToParent = false,
		content = content,
		modifier = modifier
			.requiredWidth(24.0.dp)
			.requiredHeight(24.0.dp)
	)
}

@Composable
fun TopicChirpIconStatusActive(
	modifier: Modifier = Modifier
)
{
	RelayVector(
		vector = painterResource(R.drawable.topic_chirp_icon1),
		modifier = modifier
			.padding(
				paddingValues = PaddingValues(
					start = 3.0.dp,
					top = 6.0.dp,
					end = 3.0.dp,
					bottom = 5.00360107421875.dp
				)
			)
			.fillMaxWidth(1.0f)
			.fillMaxHeight(1.0f)
	)
}


