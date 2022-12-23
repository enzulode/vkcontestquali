package com.enzulode.vkqualiapp.ui.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enzulode.vkqualiapp.repositories.Topic
import com.enzulode.vkqualiapp.topicchirp.Status
import com.enzulode.vkqualiapp.topicchirp.TopicChirp
import kotlin.math.max

@Composable
fun TopicsPart(topics: List<Topic>)
{
	val availableTopics = remember {
		topics.toMutableList()
	}

	var listOfActive: List<Int> = mutableListOf()

	Box(
		modifier = Modifier
			.fillMaxWidth(),
		contentAlignment = Alignment.CenterStart
	)
	{

		Box(modifier = Modifier.padding(10.dp))
		{
			StaggeredGrid(
				rows = topics.size / 2,
				modifier = Modifier
					.padding(horizontal = 8.dp,
					)
			)
			{

				topics.forEach { topic ->

					TopicChirp(
						title = topic.title,
						status = topic.status,
						modifier = Modifier
							.padding(5.dp)
							.pointerInput(Unit)
							{
								detectTapGestures {

									if (!listOfActive.contains(topic.id) && topic.status == Status.Inactive)
									{
										listOfActive = listOfActive.plus(topic.id)
										topic.status = Status.Active
									}
									else
									{
										listOfActive = listOfActive.drop(listOfActive.binarySearch(topic.id))
										topic.status = Status.Inactive
									}
								}
							}
					)

				}

			}
		}
	}

}

@Composable
private fun StaggeredGrid(
	modifier: Modifier = Modifier,
	rows: Int = 3,
	content: @Composable () -> Unit
) {
	Layout(
		content = content,
		modifier = modifier
	) { measurables, constraints ->
		val rowWidths = IntArray(rows) { 0 } // Keep track of the width of each row
		val rowHeights = IntArray(rows) { 0 } // Keep track of the height of each row

		// Don't constrain child views further, measure them with given constraints
		val placeables = measurables.mapIndexed { index, measurable ->
			val placeable = measurable.measure(constraints)

			// Track the width and max height of each row
			val row = index % rows
			rowWidths[row] += placeable.width
			rowHeights[row] = max(rowHeights[row], placeable.height)

			placeable
		}

		// Grid's width is the widest row
		val width = rowWidths.maxOrNull()?.coerceIn(constraints.minWidth, constraints.maxWidth)
			?: constraints.minWidth
		// Grid's height is the sum of each row
		val height = rowHeights.sum().coerceIn(constraints.minHeight, constraints.maxHeight)

		// y co-ord of each row
		val rowY = IntArray(rows) { 0 }
		for (i in 1 until rows) {
			rowY[i] = rowY[i - 1] + rowHeights[i - 1]
		}
		layout(width, height) {
			// x co-ord we have placed up to, per row
			val rowX = IntArray(rows) { 0 }
			placeables.forEachIndexed { index, placeable ->
				val row = index % rows
				placeable.place(
					x = rowX[row],
					y = rowY[row]
				)
				rowX[row] += placeable.width
			}
		}
	}
}



@Preview
@Composable
fun TopicsPartPreview()
{

	val testTopics = mutableListOf(
		Topic(1, "Кино"),
		Topic(2, "Рыбалка"),
		Topic(3, "Автомобили"),
		Topic(4, "Test1"),
		Topic(5, "Test2"),
		Topic(6, "Test3"),
		Topic(7, "Test4"),
	)

	TopicsPart(topics = testTopics)
}