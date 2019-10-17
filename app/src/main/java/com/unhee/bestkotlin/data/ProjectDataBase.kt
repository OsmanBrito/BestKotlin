package com.unhee.bestkotlin.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.unhee.bestkotlin.data.converter.OwnerConverter
import com.unhee.bestkotlin.data.dao.RepositoryDAO
import com.unhee.bestkotlin.data.entity.Repository

@Database(
    entities = [Repository::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(OwnerConverter::class)
abstract class ProjectDataBase : RoomDatabase() {
    abstract fun repositoryDAO(): RepositoryDAO

    companion object {

        @Volatile
        private var INSTANCE: ProjectDataBase? = null

        internal fun getDatabase(context: Context): ProjectDataBase? {
            if (INSTANCE == null) {
                synchronized(ProjectDataBase::class) {
                    INSTANCE =
                        Room.databaseBuilder(
                            context.applicationContext,
                            ProjectDataBase::class.java,
                            "project_database"
                        )
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build()
                }

            }
            return INSTANCE
        }
    }

    fun destroyDataBase() {
        INSTANCE = null
    }

}