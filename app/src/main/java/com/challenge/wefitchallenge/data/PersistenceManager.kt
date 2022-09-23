package com.challenge.wefitchallenge.data

import android.content.Context
import androidx.room.Room
import com.challenge.wefitchallenge.data.models.AppDatabase
import com.challenge.wefitchallenge.data.models.RepositoryInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersistenceManager(context:Context) {

    private val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()

    suspend fun saveRepository(repository: RepositoryInfo) = withContext(Dispatchers.IO) {
        db.repositoryDao().insert(repository)
    }

    suspend fun deleteRepository(repository: RepositoryInfo) = withContext(Dispatchers.IO) {
        db.repositoryDao().delete(repository)
    }

    suspend fun getAll(): List<RepositoryInfo>? = withContext(Dispatchers.IO) {
        db.repositoryDao().getAll()
    }
}