package com.finalboss.todo.core.datastore

import android.util.Log
import androidx.datastore.core.DataStore
import com.finalboss.todo.UserPreferences
import com.finalboss.todo.copy
import com.finalboss.todo.core.model.UserData
import jakarta.inject.Inject
import kotlinx.coroutines.flow.map
import java.io.IOException

class TodoPreferencesDataSource @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>,
) {
    val userData = userPreferences.data
        .map {
            UserData(
                isFirstLaunch = it.isFirstLaunch
            )
        }

    suspend fun setFirstLaunch(isFirstLaunch: Boolean) {
        try {
            userPreferences.updateData {
                it.copy {
                    this.isFirstLaunch = isFirstLaunch
                }
            }
        } catch (ioException: IOException) {
            Log.e("NiaPreferences", "Failed to update user preferences", ioException)
        }
    }
}