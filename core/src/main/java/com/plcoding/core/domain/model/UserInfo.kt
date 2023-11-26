package com.plcoding.core.domain.model

import com.plcoding.core.model.Gender
import com.plcoding.core.model.GoalType

data class UserInfo(
    val age: Int,
    val gender: Gender,
    val weight: Float,
    val height: Float,
    val activityLevel: ActivityLevel,
    val goalType: GoalType,
    val carbRatio: Float,
    val proteinRatio: Float,
    val fatRatio: Float,
)
