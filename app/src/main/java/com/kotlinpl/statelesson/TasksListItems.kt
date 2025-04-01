package com.kotlinpl.statelesson

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TaskListItems(
    list: List<TaskItem> = getTasks(),
    onCheckedTask: (TaskItem, Boolean) -> Unit,
    onCloseTask: (TaskItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(list) { task ->
            TaskItem(
                label = task.label,
                isChecked = task.isChecked,
                onClose = { onCloseTask(task) },
                onChecked = { checked -> onCheckedTask(task, checked) }
            )
        }
    }
}

fun getTasks () = List(30) { i -> TaskItem(id = i,"Tarea número $i") }

//@Preview (showBackground = true)
//@Composable
//fun TaskListItemsPreview() {
//    TaskListItems(
//        onCheckedTask = { task, boolean -> },
//        onCloseTask = {}
//    )
//}
