package com.plcoding.onbording_presentation.nutrient_goals

sealed class NutrientGoalEvent {
    data class onCarbRatioEntered(val ratio: String) : NutrientGoalEvent()
    data class onProteinRatioEntered(val ratio: String) : NutrientGoalEvent()
    data class onFatRatioEntered(val ratio: String) : NutrientGoalEvent()
    object onNextClick : NutrientGoalEvent()
}
