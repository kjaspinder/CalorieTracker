package com.plcoding.core.domain.preferences

import com.plcoding.core.domain.model.ActivityLevel
import com.plcoding.core.domain.model.UserInfo
import com.plcoding.core.model.Gender
import com.plcoding.core.model.GoalType

interface Preferences {
    fun saveAge(age: Int)
    fun saveGender(gender: Gender)
    fun saveWeight(weight: Float)
    fun saveHeight(height: Float)
    fun saveActivityLevel(activityLevel: ActivityLevel)
    fun saveGoalType(goalType: GoalType)
    fun saveCarbRatio(carbRatio: Float)
    fun saveProteinRatio(proteinRatio: Float)
    fun saveFatRatio(fatRatio: Float)
    fun getUserInfo(): UserInfo

    companion object {
        const val KEY_GENDER = "gender"
        const val KEY_AGE = "age"
        const val KEY_WEIGHT = "weight"
        const val KEY_HEIGHT = "height"
        const val KEY_ACTIVITY_LEVEL = "activity_level"
        const val KEY_GOAL_TYPE = "goal_type"
        const val KEY_CARBS_RATIO = "carbs_ratio"
        const val KEY_PROTEIN_RATIO = "protein_ratio"
        const val KEY_FAT_RATIO = "fat_ratio"
    }
}
