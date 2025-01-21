package com.finalboss.todo.core.database.di

import com.finalboss.todo.core.database.TodoDatabase
import com.finalboss.todo.core.database.dao.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun providesTaskDao(
        database: TodoDatabase
    ): TaskDao = database.taskDao()
}