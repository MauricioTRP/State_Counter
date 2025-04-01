package com.kotlinpl.statelesson

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class TasksViewModel : ViewModel() {
    private val _tasks = getTasksViewModel().toMutableStateList() // 👀
    val tasks : List<TaskItem>
        get() = _tasks

    fun remove(item: TaskItem) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: TaskItem, checked: Boolean) {
        _tasks.find { it.id == item.id }?.let { task ->
            task.isChecked = checked
        }
    }
}

private fun getTasksViewModel() = List(50) { i -> TaskItem(id = i ,label = "Tarea actual $i") }