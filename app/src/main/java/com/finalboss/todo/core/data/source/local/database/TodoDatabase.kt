package com.finalboss.todo.core.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.finalboss.todo.core.data.source.local.database.dao.LocalTaskDao
import com.finalboss.todo.core.data.source.local.database.model.LocalTask

@Database(entities = [LocalTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase: RoomDatabase(){
    abstract fun localTaskDao(): LocalTaskDao
}