package com.rosutovein.android4aproject.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rosutovein.android4aproject.domain.entity.User

@Entity
data class UserLocal(
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String
){
    @PrimaryKey(autoGenerate = true) var uid: Int? = null
}
fun User.toData() : UserLocal {
    return UserLocal(
        email = email,
        password = password
    )
}

fun UserLocal.toEntity() : User {
    return User(
        email = email,
        password = password
    )
}