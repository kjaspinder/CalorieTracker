package com.plcoding.tracker_domain.model

import java.time.LocalDate

data class TrackedFood(
    val name: String,
    val carbs: Int,
    val fat: Int,
    val protein: Int,
    val imageUrl: String?,
    val mealType: MealType,
    val amount: Int,
    val date: LocalDate,
    val calorie: Int,
    val id: Int? = null
)
