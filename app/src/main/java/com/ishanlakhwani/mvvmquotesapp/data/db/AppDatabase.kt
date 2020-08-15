package com.ishanlakhwani.mvvmquotesapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ishanlakhwani.mvvmquotesapp.data.db.entities.User

@Database(
    entities =  [User::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object{

        @Volatile
        private var instace: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instace?: synchronized(LOCK){
            instace?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db")
                .build()

    }

}