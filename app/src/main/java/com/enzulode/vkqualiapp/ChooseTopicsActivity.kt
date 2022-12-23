package com.enzulode.vkqualiapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.enzulode.vkqualiapp.repositories.Topic
import com.enzulode.vkqualiapp.ui.components.ContinueBar
import com.enzulode.vkqualiapp.ui.components.LaterBar
import com.enzulode.vkqualiapp.ui.components.TopicsPart

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
				LaterBar(
					text = "Отметьте то, что Вам интересно, чтобы настроить Дзен",
					onClick = {
						val intent = Intent(this@ChooseTopicsActivity, FinalActivity::class.java)
						startActivity(intent)
					}
				)

				val testTopics = mutableListOf(
					Topic(1, "Юмор"),
					Topic(2, "Еда"),
					Topic(3, "Кино"),
					Topic(4, "Рестораны"),
					Topic(5, "Прогулки"),
					Topic(6, "Политика"),
					Topic(7, "Новости"),
					Topic(8, "Автомобили"),
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

				TopicsPart(topics = testTopics)

				ContinueBar()
			}

		}
	}

}