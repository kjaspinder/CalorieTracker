package com.plcoding.calorytracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.calorytracker.navigation.navigate
import com.plcoding.calorytracker.ui.theme.CaloryTrackerTheme
import com.plcoding.core.navigation.Route
import com.plcoding.onbording_presentation.activity.ActivityScreen
import com.plcoding.onbording_presentation.age.AgeScreen
import com.plcoding.onbording_presentation.gender.GenderScreen
import com.plcoding.onbording_presentation.goal.GoalScreen
import com.plcoding.onbording_presentation.height.HeightScreen
import com.plcoding.onbording_presentation.nutrient_goals.NutrientGoalScreen
import com.plcoding.onbording_presentation.weight.WeightScreen
import com.plcoding.onbording_presentation.welcome.WelcomeScreen
import com.plcoding.tracker_presentation.tracker_overview.TrackerOverviewScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState,
                ) {
                    NavHost(navController = navController, startDestination = Route.WELCOME) {
                        composable(Route.WELCOME) {
                            WelcomeScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.AGE) {
                            AgeScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate,
                            )
                        }
                        composable(Route.GENDER) {
                            GenderScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.WEIGHT) {
                            WeightScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate,
                            )
                        }
                        composable(Route.HEIGHT) {
                            HeightScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate,
                            )
                        }
                        composable(Route.NUTRIENT_GOAL) {
                            NutrientGoalScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate,
                            )
                        }
                        composable(Route.ACTIVITY) {
                            ActivityScreen(
                                onNavigate = navController::navigate,
                            )
                        }
                        composable(Route.GOAL) {
                            GoalScreen(
                                onNavigate = navController::navigate,
                            )
                        }
                        composable(Route.TRACKER_OVERVIEW) {
                            TrackerOverviewScreen(
                                onNavigate = navController::navigate,
                            )
                        }
                        composable(Route.SEARCH) {
                        }
                    }
                }
            }
        }
    }
}
