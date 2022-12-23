package com.enzulode.vkqualiapp.repositories

import com.enzulode.vkqualiapp.topicchirp.Status

data class Topic(
	val id: Int,
	val title: String,
	var status: Status = Status.Inactive
)
