package com.finalboss.todo.core.data.source.local.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.finalboss.todo.core.repository.Task

@Entity(
    tableName = "task"
)
data class LocalTask(
    @PrimaryKey val id: String,
    var title: String,
    var description: String,
    var isCompleted: Boolean
)

fun Task.mapToLocalTask() = LocalTask(
    id = id,
    title = title,
    description = description,
    isCompleted = isCompleted
)

