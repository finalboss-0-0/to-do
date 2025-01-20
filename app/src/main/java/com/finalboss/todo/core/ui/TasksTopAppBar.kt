package com.finalboss.todo.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.finalboss.todo.R
import com.finalboss.todo.core.designsystem.icon.TodoIcon
import com.finalboss.todo.core.designsystem.theme.ToDoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksTopAppBar(
    openDrawer: () -> Unit,
    onFilterAllTasks: () -> Unit,
    onFilterActiveTasks: () -> Unit,
    onFilterCompletedTasks: () -> Unit,
    onClearCompletedTasks: () -> Unit,
    onRefresh: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = { Text(text = stringResource(id = R.string.app_name)) },
        navigationIcon = {
            IconButton(onClick = { openDrawer() }) {
                Icon(imageVector = TodoIcon.Menu, contentDescription = null)
            }
        },
        actions = {
            FilterTasksMenu(
                onFilterAllTasks = onFilterAllTasks,
                onFilterActiveTasks = onFilterActiveTasks,
                onFilterCompletedTasks = onFilterCompletedTasks
            )
            MoreTasksMenu(onClearCompletedTasks = onClearCompletedTasks, onRefresh = onRefresh)
        }
    )
}

@Composable
fun FilterTasksMenu(
    onFilterAllTasks: () -> Unit,
    onFilterActiveTasks: () -> Unit,
    onFilterCompletedTasks: () -> Unit
) {
    TopAppBarDropdownMenu(
        iconContent = {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter_list),
                contentDescription = null
            )
        }
    ) { closeMenu ->
        DropdownMenuItem(
            text = { stringResource(id = R.string.nav_all) },
            onClick = {
                onFilterAllTasks()
                closeMenu()
            }
        )
        DropdownMenuItem(
            text = { stringResource(id = R.string.nav_active) },
            onClick = {
                onFilterActiveTasks()
                closeMenu()
            }
        )
        DropdownMenuItem(
            text = { stringResource(id = R.string.nav_completed) },
            onClick = {
                onFilterCompletedTasks()
                closeMenu()
            }
        )
    }
}

@Composable
fun MoreTasksMenu(
    onClearCompletedTasks: () -> Unit,
    onRefresh: () -> Unit
) {
    TopAppBarDropdownMenu(iconContent = { TodoIcon.MoreVert }) { closeMenu ->
        DropdownMenuItem(
            text = { stringResource(id = R.string.menu_clear) },
            onClick = { onClearCompletedTasks() }
        )
        DropdownMenuItem(
            text = { stringResource(id = R.string.refresh) },
            onClick = { onRefresh() }
        )
    }
}

@Composable
fun TopAppBarDropdownMenu(
    iconContent: @Composable () -> Unit,
    content: @Composable ColumnScope.(() -> Unit) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = Modifier.wrapContentSize()) {
        IconButton(onClick = { expanded = !expanded }) {
            iconContent()
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.wrapContentSize()
        ) {
            content { expanded = !expanded }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TasksTopAppBarPreview() {
    ToDoTheme {
        TasksTopAppBar(
            openDrawer = { /*TODO*/ },
            onFilterAllTasks = { /*TODO*/ },
            onFilterActiveTasks = { /*TODO*/ },
            onFilterCompletedTasks = { /*TODO*/ },
            onClearCompletedTasks = { /*TODO*/ }) {
            
        }
    }
}