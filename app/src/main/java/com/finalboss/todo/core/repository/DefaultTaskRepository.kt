package com.finalboss.todo.core.repository

import com.finalboss.todo.core.common.di.ApplicationScope
import com.finalboss.todo.core.data.source.local.database.dao.LocalTaskDao
import com.finalboss.todo.core.data.source.local.database.model.mapToLocalTask
import com.finalboss.todo.core.data.source.network.NetworkDataSource
import com.finalboss.todo.core.data.source.network.model.mapToNetwork
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Default implementation of [TaskRepository]. Single entry point for managing tasks' data.
 *
 * @param networkDataSource - The network data source
 * @param localTaskDao - The local data source
 * @param dispatcher - The dispatcher to be used for long running or complex operations, such as ID
 * generation or mapping many models.
 * @param scope - The coroutine scope used for deferred jobs where the result isn't important, such
 * as sending data to the network.
 */
@Singleton
class DefaultTaskRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val localTaskDao: LocalTaskDao,
    @ApplicationScope private val applicationScope: CoroutineScope
): TaskRepository {
    override suspend fun createTask(title: String, description: String): String {
        // ID creation might be a complex operation so it's executed using the supplied
        // coroutine dispatcher
        val taskId = withContext(Dispatchers.Default) {
            UUID.randomUUID().toString()
        }
        val task = Task(
            title = title,
            description = description,
            id = taskId
        )
        localTaskDao.upsert(task.mapToLocalTask())
        saveTasksToNetwork()
        return taskId
    }

    override fun getTasksStream(): Flow<List<Task>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTasks(forceUpdate: Boolean): List<Task> {
        TODO("Not yet implemented")
    }

    override suspend fun refresh() {
        TODO("Not yet implemented")
    }

    override fun getTaskStream(taskId: String): Flow<Task?> {
        TODO("Not yet implemented")
    }

    override suspend fun getTask(taskId: String, forceUpdate: Boolean): Task? {
        TODO("Not yet implemented")
    }

    override suspend fun refreshTask(taskId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateTask(taskId: String, title: String, description: String) {
        TODO("Not yet implemented")
    }

    override suspend fun completeTask(taskId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun activeTask(taskId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun clearCompletedTasks() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllTasks() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTask(taskId: String) {
        TODO("Not yet implemented")
    }

    /**
     * Send the tasks from the local data source to the network data source
     *
     * Returns immediately after launching the job. Real apps may want to suspend here until the
     * operation is complete or (better) use WorkManager to schedule this work. Both approaches
     * should provide a mechanism for failures to be communicated back to the user so that
     * they are aware that their data isn't being backed up.
     */
    private fun saveTasksToNetwork() {
        applicationScope.launch {
            try {
                val localTasks = localTaskDao.getAll()
                val networkTasks = withContext(Dispatchers.IO) {
                    localTasks.mapToNetwork()
                }
                networkDataSource.saveTasks(networkTasks)
            } catch (e: Exception) {
                // In a real app you'd handle the exception e.g. by exposing a `networkStatus` flow
                // to an app level UI state holder which could then display a Toast message.
            }
        }
    }
}