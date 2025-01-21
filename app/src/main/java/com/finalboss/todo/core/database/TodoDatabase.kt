package com.finalboss.todo.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.finalboss.todo.core.database.dao.TaskDao

@Database(
    entities = [],
    version = 0,
    autoMigrations = [],
    exportSchema = true
)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}