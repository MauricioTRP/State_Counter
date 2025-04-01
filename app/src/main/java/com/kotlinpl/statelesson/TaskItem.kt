package com.kotlinpl.statelesson

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskItem(
    label: String,
    isChecked: Boolean,
    onChecked: (Boolean) -> Unit, // TODO("Implementar")
    onClose: () -> Unit, // TODO("Implement")
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            label,
            modifier = Modifier.weight(1f).padding(start = 8.dp)
        )

        Checkbox(
            checked = isChecked,
            onCheckedChange = onChecked
        )

        IconButton(
            onClick = onClose
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskItemPreview() {
    val task = TaskItem(id = 1, label = "Mi tarea")

    TaskItem(
        label = task.label,
        isChecked = task.isChecked,
        onChecked = { task.isChecked = !task.isChecked },
        onClose = {}
    )
}