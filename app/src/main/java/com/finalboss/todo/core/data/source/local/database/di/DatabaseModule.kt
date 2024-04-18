package com.finalboss.todo.core.data.source.local.database.di

import android.content.Context
import androidx.room.Room
import com.finalboss.todo.core.data.source.local.database.TodoDatabase
import com.finalboss.todo.core.data.source.local.database.dao.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context = context.applicationContext,
            TodoDatabase::class.java,
            "Tasks.db"
        ).build()
    }

    @Provides
    fun provideTaskDao(database: TodoDatabase): TaskDao = database.taskDao()
}