package com.rosutovein.android4aproject.data.repository

import com.rosutovein.android4aproject.data.local.DatabaseDao
import com.rosutovein.android4aproject.data.local.models.UserLocal
import com.rosutovein.android4aproject.data.local.models.toData
import com.rosutovein.android4aproject.data.local.models.toEntity
import com.rosutovein.android4aproject.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
) {

    suspend fun createUser(user: User){
        databaseDao.insert(user.toData())

    }
    fun getUser(email: String, password: String): User? {
        val userLocal: UserLocal? = databaseDao.findByName(email, password)
        return userLocal?.toEntity()
    }
}