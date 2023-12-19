package com.plcoding.tracker_presentation.tracker_overview

import com.plcoding.tracker_domain.model.TrackedFood

sealed class TrackerOverviewEvent {
    object onNextDayClick : TrackerOverviewEvent()
    object onPreviousDayClick : TrackerOverviewEvent()
    data class onToggleMealClicked(val meal: Meal) : TrackerOverviewEvent()
    data class OnDeleteTrackedFoodClick(val trackedFood: TrackedFood) : TrackerOverviewEvent()
    data class onAddFoodClick(val meal: Meal): TrackerOverviewEvent()
}
