package com.finalboss.todo.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.finalboss.todo.feature.tasks.navigation.TasksRoute
import com.finalboss.todo.feature.tasks.navigation.tasksScreen

@Composable
fun TodoNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = TasksRoute,
        modifier = modifier
    ) {
        tasksScreen()
    }
}