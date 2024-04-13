package com.finalboss.todo.feature.task.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.finalboss.todo.feature.task.TasksRoute

const val TASKS_ROUTE = "tasks_route"
private const val DEEP_LINK_URI_PATTERN =
    "https://www.finalboss.com/todo/tasks"
fun NavController.navigateToTasks(navOptions: NavOptions) = navigate(TASKS_ROUTE)

fun NavGraphBuilder.tasksScreen() {
    composable(
        route = TASKS_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = DEEP_LINK_URI_PATTERN }
        )

    ) {
        TasksRoute()
    }
}