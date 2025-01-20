package com.finalboss.todo.feature.tasks

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.finalboss.todo.core.ui.TasksTopAppBar

@Composable
fun TasksRoute(
    viewModel: TasksViewModel = hiltViewModel(),
    openDrawer: () -> Unit
) {
    TasksScreen(
        openDrawer = openDrawer
    )
}

@Composable
fun TasksScreen(
    openDrawer: () -> Unit,
) {
    Scaffold(
        topBar = {
            TasksTopAppBar(
                openDrawer = openDrawer,
                onFilterAllTasks = { /*TODO*/ },
                onFilterActiveTasks = { /*TODO*/ },
                onFilterCompletedTasks = { /*TODO*/ },
                onClearCompletedTasks = { /*TODO*/ }) {

            }
        }
    ) { paddingValues ->
    }
}