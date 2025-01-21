package com.finalboss.todo.core.model

data class Task(
    val id: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
) {
    val titleForList: String
        get() = if (title.isNotEmpty()) title else description

    val isActive: Boolean
        get() = !isCompleted

    val isEmpty: Boolean
        get() = title.isEmpty() || description.isEmpty()
}
