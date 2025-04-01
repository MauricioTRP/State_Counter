package com.kotlinpl.statelesson

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TasksScreen(
    modifier: Modifier = Modifier,
    tasksViewModel: TasksViewModel = viewModel()
) {
    TaskListItems(
        list = tasksViewModel.tasks,
        onCheckedTask = { task, checked ->
            tasksViewModel.changeTaskChecked(task, checked)
        },
        onCloseTask = { task ->
            tasksViewModel.remove(task)
        },
        modifier = modifier
    )
}