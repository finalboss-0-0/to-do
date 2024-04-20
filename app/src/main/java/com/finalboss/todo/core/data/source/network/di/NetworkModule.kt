package com.finalboss.todo.core.data.source.network.di

import com.finalboss.todo.core.data.source.network.NetworkDataSource
import com.finalboss.todo.core.data.source.network.TaskNetworkDatasource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {
    @Singleton
    @Binds
    abstract fun bindNetworkDataSource(dataSource: TaskNetworkDatasource): NetworkDataSource
}