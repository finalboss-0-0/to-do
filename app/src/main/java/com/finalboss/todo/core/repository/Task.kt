package com.finalboss.todo.core.repository

data class Task(
    var title: String = "",
    val description: String = "",
    val isCompleted: Boolean = false,
    val id: String,
) {
    val titleForList: String
        get() = if (title.isNotEmpty()) title else description
    val isActive
        get() = !isCompleted
    val isEmpty
        get() = title.isEmpty() || description.isEmpty()
}
