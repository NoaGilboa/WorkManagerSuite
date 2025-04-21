package com.example.common.models

import java.io.Serializable

data class Employee(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val identityNumber: String,
    val monthlyHours: Float,
    val hourlyWage: Float
) : Serializable {
    val monthlySalary: Float
        get() = monthlyHours * hourlyWage

    fun fullName(): String = "$firstName $lastName"
}