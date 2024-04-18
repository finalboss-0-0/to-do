package com.finalboss.todo.core.repository

import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasksStream(): Flow<List<Task>>

    suspend fun getTasks(forceUpdate: Boolean = false): List<Task>
    suspend fun refresh()
    fun getTaskStream(taskId: String): Flow<Task?>
    suspend fun getTask(taskId: String, forceUpdate: Boolean = false): Task?
    suspend fun refreshTask(taskId: String)
    suspend fun createTask(title: String, description: String): String
    suspend fun updateTask(taskId: String, title: String, description: String)
    suspend fun completeTask(taskId: String)
    suspend fun activeTask(taskId: String)
    suspend fun clearCompletedTasks()
    suspend fun deleteAllTasks()
    suspend fun deleteTask(taskId: String)
}