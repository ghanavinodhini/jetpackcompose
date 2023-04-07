package com.example.jetpackcompose.feature_todotasks.data.data_source.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.jetpackcompose.di.AppModule
import com.example.jetpackcompose.feature_todotasks.domain.model.Todo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Todo :: class], version = 1)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao() : TodoDao

    class Callback @Inject constructor(
        private val database: Provider<TodoDatabase>,
        @AppModule.ApplicationScope private val applicationScope: CoroutineScope
        ) : RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            //db operations
            val dao = database.get().todoDao()

            applicationScope.launch {
                //execute suspend functions inside coroutinescope
                dao.insert(Todo("Wash the dishes",System.currentTimeMillis().toString(),false,1))
                dao.insert(Todo("Do the laundry",System.currentTimeMillis().toString(),false,2))
                dao.insert(Todo("Buy groceries",System.currentTimeMillis().toString(),true,3))
                dao.insert(Todo("Cook dinner",System.currentTimeMillis().toString(),false,4))
                dao.insert(Todo("Do exercise",System.currentTimeMillis().toString(),false,5))
            }

        }
    }
}