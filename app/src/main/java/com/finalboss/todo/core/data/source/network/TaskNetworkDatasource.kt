package com.finalboss.todo.core.data.source.network

import com.finalboss.todo.core.data.source.network.model.NetworkTask
import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

private const val SERVICE_LATENCY_IN_MILLIS = 2000L

class TaskNetworkDatasource : NetworkDataSource {
    private val accessMutex = Mutex()
    private var tasks = listOf(
        NetworkTask(
            id = "PISA",
            title = "Build tower in Pisa",
            shortDescription = "Ground looks good, no foundation work required."
        ),
        NetworkTask(
            id = "TACOMA",
            title = "Finish bridge in Tacoma",
            shortDescription = "Found awesome girders at half the cost!"
        )
    )
    override suspend fun localTasks(): List<NetworkTask> = accessMutex.withLock {
        delay(SERVICE_LATENCY_IN_MILLIS)
        return tasks
    }

    override suspend fun saveTasks(tasks: List<NetworkTask>) {
        TODO("Not yet implemented")
    }
}