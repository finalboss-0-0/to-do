package com.finalboss.todo.core.repository.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class Dispatcher(val todoDispatcher: TodoDispatchers)

enum class TodoDispatchers{
    Default,
    IO
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope