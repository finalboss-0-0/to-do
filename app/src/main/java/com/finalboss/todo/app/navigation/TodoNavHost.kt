package com.finalboss.todo.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.finalboss.todo.feature.task.navigation.tasksScreen

@Composable
fun TodoNavHost(
    modifier: Modifier = Modifier,
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        tasksScreen()
    }
}