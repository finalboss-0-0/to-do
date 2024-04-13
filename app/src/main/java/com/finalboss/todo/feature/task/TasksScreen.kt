package com.finalboss.todo.feature.task

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TasksRoute(
    modifier: Modifier = Modifier,
    viewModel: TasksViewModel = hiltViewModel()
) {
    TasksScreen(
        modifier = modifier
    )
}

@Composable
fun TasksScreen(
    modifier: Modifier = Modifier
) {

}