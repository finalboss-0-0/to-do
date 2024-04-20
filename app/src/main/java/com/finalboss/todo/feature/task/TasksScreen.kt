package com.finalboss.todo.feature.task

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.finalboss.todo.core.ui.TasksTopAppBar

@Composable
fun TasksRoute(
    modifier: Modifier = Modifier,
    viewModel: TasksViewModel = hiltViewModel(),
    openDrawer: () -> Unit
) {
    TasksScreen(
        modifier = modifier,
        openDrawer = openDrawer
    )
}

@Composable
fun TasksScreen(
    modifier: Modifier = Modifier,
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