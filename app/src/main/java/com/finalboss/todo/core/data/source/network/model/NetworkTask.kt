package com.finalboss.todo.core.data.source.network.model

import com.finalboss.todo.core.data.source.local.database.model.LocalTask

data class NetworkTask(
    val id: String,
    val title: String,
    val shortDescription: String,
    val priority: Int? = null,
    val status: TaskStatus = TaskStatus.ACTIVE
)

enum class TaskStatus {
    ACTIVE,
    COMPLETE
}

fun LocalTask.mapToNetwork() = NetworkTask(
    id = id,
    title = title,
    shortDescription = description,
    status = if (isCompleted) {
        TaskStatus.COMPLETE
    } else {
        TaskStatus.ACTIVE
    }
)

fun List<LocalTask>.mapToNetwork() = map(LocalTask::mapToNetwork)
