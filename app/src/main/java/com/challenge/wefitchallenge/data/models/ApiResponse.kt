package com.challenge.wefitchallenge.data.models

import androidx.room.*

class ApiResponse : ArrayList<RepositoryInfo>()

@Dao
interface RepositoryDao {

    @Query("SELECT * FROM repositoryInfo")
    fun getAll(): List<RepositoryInfo>?

    @Insert
    fun insert(repository: RepositoryInfo)

    @Delete
    fun delete(repository: RepositoryInfo)
}

@Database(entities = [RepositoryInfo::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repositoryDao(): RepositoryDao
}