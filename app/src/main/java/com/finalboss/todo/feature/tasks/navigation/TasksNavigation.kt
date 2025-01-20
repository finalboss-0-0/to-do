package com.finalboss.todo.feature.tasks.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.finalboss.todo.feature.tasks.TasksRoute
import kotlinx.serialization.Serializable

@Serializable
data object TasksRoute
fun NavController.navigateToTasks(navOptions: NavOptions? = null) {
    navigate(
        route = TasksRoute,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.tasksScreen() {
    composable<TasksRoute> {
        TasksRoute {  }
    }
}