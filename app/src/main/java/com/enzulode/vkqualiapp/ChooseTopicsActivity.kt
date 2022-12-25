package com.enzulode.vkqualiapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enzulode.vkqualiapp.repositories.Topic
import com.enzulode.vkqualiapp.ui.components.ContinueButton
import com.enzulode.vkqualiapp.ui.components.LaterButton
import com.enzulode.vkqualiapp.ui.components.TopicChirp
import com.enzulode.vkqualiapp.ui.theme.VkQualiAppTheme
import kotlin.math.max

class ChooseTopicsActivity : ComponentActivity()
{

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		val topicsList = retrieveDebugData()

		setContent {

			VkQualiAppTheme() {

				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				)
				{

					Column(
						modifier = Modifier
							.fillMaxSize()
					)
					{
						//					Later bar
						Row(
							modifier = Modifier
								.fillMaxWidth()
								.height(100.dp)
								.padding(6.dp),
							horizontalArrangement = Arrangement.SpaceEvenly
						)
						{

							Column(
								verticalArrangement = Arrangement.Center,
								horizontalAlignment = Alignment.Start
							)
							{

								Box(modifier = Modifier.padding(10.dp, 10.dp, 3.dp, 10.dp), contentAlignment = Alignment.Center)
								{
//								Later bar text
									Text(
										text = "Отметьте то, что Вам интересно, чтобы настроить Дзен",
										color = Color.DarkGray,
										fontSize = 16.sp,
										modifier = Modifier.widthIn(max = 250.dp)
									)
								}

							}

							Column(
								verticalArrangement = Arrangement.Center,
								horizontalAlignment = Alignment.End
							)
							{
								Box(modifier = Modifier.padding(3.dp, 10.dp, 10.dp, 10.dp), contentAlignment = Alignment.Center)
								{
//								Later button space
									LaterButton(
										title = "Позже",
										onTapped = {
											val intent = Intent(this@ChooseTopicsActivity, FinalActivity::class.java)
											startActivity(intent)
										}
									)
								}
							}

						}
//					Later bar ended

//					Topics area
						Box(
							modifier = Modifier
								.padding(10.dp),
							contentAlignment = Alignment.Center,
						)
						{

							Column(
								modifier = Modifier
									.fillMaxWidth()
							)
							{

								Box(
									modifier = Modifier
										.padding(10.dp)
										.verticalScroll(rememberScrollState()),
									contentAlignment = Alignment.TopStart
								)
								{

									StaggeredGrid(
										rows = topicsList.size / 2,
										modifier = Modifier
											.padding(horizontal = 8.dp)
									)
									{

										topicsList.forEach { topic ->
											TopicChirp(
												title = topic.title,
												modifier = Modifier
													.padding(5.dp)
											)
										}

									}

								}
							}

						}
//					End of topics
					}

//					Continue bar
					Row(
						modifier = Modifier
							.fillMaxWidth()
							.height(100.dp)
							.padding(6.dp),
						horizontalArrangement = Arrangement.Center,
						verticalAlignment = Alignment.Bottom
					)
					{
						Box(
							modifier = Modifier
								.padding(10.dp),
							contentAlignment = Alignment.Center
						)
						{
							ContinueButton(
								title = "Продолжить",
								onTapped = {
									Toast.makeText(this@ChooseTopicsActivity, "Success", Toast.LENGTH_SHORT).show()
								}
							)
						}
					}
//					Continue bar ended

				}

			}

		}
	}


	@Composable
	private fun StaggeredGrid(
		modifier: Modifier = Modifier,
		rows: Int = 3,
		content: @Composable () -> Unit
	)
	{
		Layout(
			content = content,
			modifier = modifier
		)
		{ measurables, constraints ->
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
			var width = rowWidths.maxOrNull()?.coerceIn(constraints.minWidth, constraints.maxWidth)
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
					rowX[row] += placeable.width - 10
				}
			}
		}
	}

	private fun retrieveDebugData(): MutableList<Topic>
	{
		return mutableListOf(
			Topic(1, "Юмор"),
			Topic(2, "Еда"),
			Topic(3, "Кино"),
			Topic(9, "Сериалы"),
			Topic(10, "Рецепты"),
			Topic(11, "Работа"),
			Topic(12, "Отдых"),
			Topic(13, "Спорт"),
			Topic(14, "Юмор"),
			Topic(15, "Еда"),
			Topic(16, "Кино"),
			Topic(17, "Кино"),
			Topic(18, "Рестораны"),
			Topic(19, "Прогулки"),
			Topic(20, "Отдых"),
			Topic(21, "Спорт"),
			Topic(22, "Политика"),
			Topic(23, "Новости"),
			Topic(24, "Еда"),
			Topic(25, "Кино")
		)
	}

}