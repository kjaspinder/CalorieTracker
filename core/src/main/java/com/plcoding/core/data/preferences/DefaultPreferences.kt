package com.plcoding.core.domain

import android.content.SharedPreferences
import com.plcoding.core.domain.model.ActivityLevel
import com.plcoding.core.domain.model.UserInfo
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.core.model.Gender
import com.plcoding.core.model.GoalType

class DefaultPreferences(
    private val sharedPref: SharedPreferences,
) : Preferences {
    override fun saveAge(age: Int) {
        sharedPref.edit().putInt(Preferences.KEY_AGE, age).apply()
    }

    override fun saveGender(gender: Gender) {
        sharedPref.edit().putString(Preferences.KEY_GENDER, gender.name).apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPref.edit().putFloat(Preferences.KEY_WEIGHT, weight).apply()
    }

    override fun saveHeight(height: Float) {
        sharedPref.edit().putFloat(Preferences.KEY_HEIGHT, height).apply()
    }

    override fun saveActivityLevel(activityLevel: ActivityLevel) {
        sharedPref.edit().putString(Preferences.KEY_ACTIVITY_LEVEL, activityLevel.name).apply()
    }

    override fun saveGoalType(goalType: GoalType) {
        sharedPref.edit().putString(Preferences.KEY_GOAL_TYPE, goalType.name).apply()
    }

    override fun saveCarbRatio(carbRatio: Float) {
        sharedPref.edit().putFloat(Preferences.KEY_CARBS_RATIO, carbRatio).apply()
    }

    override fun saveProteinRatio(proteinRatio: Float) {
        sharedPref.edit().putFloat(Preferences.KEY_PROTEIN_RATIO, proteinRatio).apply()
    }

    override fun saveFatRatio(fatRatio: Float) {
        sharedPref.edit().putFloat(Preferences.KEY_FAT_RATIO, fatRatio).apply()
    }

    override fun getUserInfo(): UserInfo {
        val age = sharedPref.getInt(Preferences.KEY_AGE, 0)
        val genderString = sharedPref.getString(Preferences.KEY_GENDER, "male")
        val weight = sharedPref.getFloat(Preferences.KEY_WEIGHT, -1f)
        val height = sharedPref.getFloat(Preferences.KEY_HEIGHT, -1f)
        val activityLevelString = sharedPref.getString(Preferences.KEY_ACTIVITY_LEVEL, "medium")
        val goalTypeString = sharedPref.getString(Preferences.KEY_GOAL_TYPE, "keep_weight")
        val carbRatio = sharedPref.getFloat(Preferences.KEY_CARBS_RATIO, 1f)
        val fatRatio = sharedPref.getFloat(Preferences.KEY_CARBS_RATIO, 1f)
        val proteinRatio = sharedPref.getFloat(Preferences.KEY_PROTEIN_RATIO, 1f)

        return UserInfo(
            age,
            Gender.fromString(genderString ?: "male"),
            weight,
            height,
            ActivityLevel.fromString(activityLevelString ?: "medium"),
            GoalType.fromString(goalTypeString ?: "keep_weight"),
            carbRatio,
            proteinRatio,
            fatRatio,
        )
    }
}
