package com.kotlinpl.statelesson

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class TaskItem(
    val id: Int,
    val label: String,
    isInitialChecked: Boolean = false
) {
    var isChecked by mutableStateOf(isInitialChecked)
}
