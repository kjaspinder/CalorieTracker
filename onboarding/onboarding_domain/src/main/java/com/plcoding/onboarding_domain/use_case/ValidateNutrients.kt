package com.plcoding.onboarding_domain.use_case

import com.plcoding.core.R
import com.plcoding.core.util.UiText

class ValidateNutrients {

    operator fun invoke(
        carbsRatioText: String,
        proteinRatioText: String,
        fatRatioText: String,
    ): Result {
        val carbsRatio = carbsRatioText.toIntOrNull()
        val proteinRatio = proteinRatioText.toIntOrNull()
        val fatRatio = fatRatioText.toIntOrNull()
        if (carbsRatio == null || proteinRatio == null || fatRatio == null) {
            return Result.Error(UiText.StringResource(R.string.error_invalid_values))
        }
        if (carbsRatio + proteinRatio + fatRatio != 100) {
            return Result.Error(UiText.StringResource(R.string.error_invalid_values))
        }
        return Result.Success(
            carbs = carbsRatio / 100f,
            protein = proteinRatio / 100f,
            fat = fatRatio / 100f,
        )
    }

    sealed class Result {
        data class Success(
            val carbs: Float,
            val protein: Float,
            val fat: Float,
        ) : Result()

        data class Error(val message: UiText) : Result()
    }
}
