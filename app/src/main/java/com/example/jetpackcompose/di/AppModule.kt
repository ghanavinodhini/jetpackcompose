package com.example.jetpackcompose.di

import android.app.Application
import androidx.room.Room
import com.example.jetpackcompose.feature_todotasks.data.data_source.room.TodoDao
import com.example.jetpackcompose.feature_todotasks.data.data_source.room.TodoDatabase
import com.example.jetpackcompose.feature_todotasks.data.repository.TodoRepositoryImpl
import com.example.jetpackcompose.feature_todotasks.domain.repository.TodoRepository
import com.example.jetpackcompose.feature_todotasks.domain.use_case.AddTask
import com.example.jetpackcompose.feature_todotasks.domain.use_case.DeleteTask
import com.example.jetpackcompose.feature_todotasks.domain.use_case.GetTasks
import com.example.jetpackcompose.feature_todotasks.domain.use_case.TodoUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

//Module is a place where we give instructions to dagger on how to create the dependencies we need
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton //creates only one instance of DB and dao
    fun provideTodoDatabase(
        app:Application
        //callback: TodoDatabase.Callback
    ):TodoDatabase
    {
       return Room.databaseBuilder(
           app,
           TodoDatabase::class.java,
           "todo_database")
           // .fallbackToDestructiveMigration() //destruct table and creates new database
           // .addCallback(callback)
            .build() //creates one instance of TodoDatabase class
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: TodoDatabase) : TodoRepository{
        return TodoRepositoryImpl(db.todoDao())
    }

    @Provides
    @Singleton
    fun provideTodoUseCases(repository: TodoRepository) : TodoUseCases{
        return TodoUseCases(
            getTasks = GetTasks(repository),
            deleteTask = DeleteTask(repository),
            addTask = AddTask(repository)
        )
    }

   /* @Provides
    fun provideTaskDao(db : TodoDatabase) = db.todoDao()

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class ApplicationScope*/
}