package com.oppo.finance.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oppo.finance.core.db.entity.User
import com.oppo.finance.utils.DATABASE_NAME

@Database(
    entities = [User::class, User::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseServiceDao(): DatabaseService

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java, DATABASE_NAME
        ).build()
    }
}