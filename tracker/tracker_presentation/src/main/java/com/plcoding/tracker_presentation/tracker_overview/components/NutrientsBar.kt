package com.plcoding.tracker_presentation.tracker_overview.components

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.LastBaseline
import com.plcoding.core.CarbColor
import com.plcoding.core.FatColor
import com.plcoding.core.ProteinColor

@Composable
fun NutrientsBar(
    carbs: Int,
    protein: Int,
    fat: Int,
    calories: Int,
    calorieGoal: Int,
    modifier: Modifier = Modifier
) {
    val background = MaterialTheme.colors.background
    val caloriesExceededColor = MaterialTheme.colors.error
    val carbsWidthRatio = remember {
        Animatable(0f)
    }
    val proteinWithRatio = remember {
        Animatable(0f)
    }
    val fatWidthRatio = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = carbs) {
        carbsWidthRatio.animateTo(
            targetValue = ((carbs * 4f) / calorieGoal),
        )
    }
    LaunchedEffect(key1 = carbs) {
        proteinWithRatio.animateTo(
            targetValue = ((protein * 4f) / calorieGoal),
        )
    }
    LaunchedEffect(key1 = carbs) {
        fatWidthRatio.animateTo(
            targetValue = ((fat * 9f) / calorieGoal),
        )
    }

    Canvas(modifier = modifier) {
        if(calories <= calorieGoal) {
            val carbsWidth = carbsWidthRatio.value * size.width
            val proteinWidth = proteinWithRatio.value * size.width
            val fatWidth = fatWidthRatio.value * size.width
            drawRoundRect(
                color = background,
                size = size,
                cornerRadius = CornerRadius(100f),
            )
            drawRoundRect(
                color = FatColor,
                size = Size(
                    width = carbsWidth + proteinWidth + fatWidth,
                    height = size.height,
                ),
                cornerRadius = CornerRadius(100f),
            )
            drawRoundRect(
                color = ProteinColor,
                size = Size(
                    width = carbsWidth + proteinWidth,
                    height = size.height,
                ),
                cornerRadius = CornerRadius(100f),
            )
            drawRoundRect(
                color = CarbColor,
                size = Size(
                    width = carbsWidth,
                    height = size.height,
                ),
                cornerRadius = CornerRadius(100f),
            )
        } else {
            drawRoundRect(
                color = caloriesExceededColor,
                size = size,
                cornerRadius = CornerRadius(100f),
            )
        }
    }
}