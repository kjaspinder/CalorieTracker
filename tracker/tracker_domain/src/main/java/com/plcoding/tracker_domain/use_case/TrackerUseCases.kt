package com.plcoding.tracker_domain.use_case

data class TrackerUseCases(
    val trackfood: Trackfood,
    val searchFood: SearchFood,
    val deleteTrackedFood: DeleteTrackedFood,
    val getFoodsForDate: GetFoodsForDate,
    val calculateMealNutrients: CalculateMealNutrients
)