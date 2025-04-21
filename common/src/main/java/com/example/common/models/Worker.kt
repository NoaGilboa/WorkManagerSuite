package com.example.common.models

import java.io.Serializable

data class Worker(
    val id: Int,
    val date: String,
    val day: String,
    val startTime: String,
    val endTime: String
): Serializable {
    val totalHours: Float
        get() = 8.0f
}



