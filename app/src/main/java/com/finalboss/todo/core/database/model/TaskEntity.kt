package com.finalboss.todo.core.database.model

import androidx.room.PrimaryKey

data class TaskEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
)