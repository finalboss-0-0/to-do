package com.finalboss.todo.core.data.source.network

import com.finalboss.todo.core.data.source.network.model.NetworkTask

interface NetworkDataSource {
    suspend fun localTasks():List<NetworkTask>
    suspend fun saveTasks(tasks: List<NetworkTask>)
}