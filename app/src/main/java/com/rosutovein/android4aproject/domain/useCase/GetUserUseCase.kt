package com.rosutovein.android4aproject.domain.useCase

import com.rosutovein.android4aproject.data.repository.UserRepository
import com.rosutovein.android4aproject.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String): User?{
       return userRepository.getUser(email)
    }
}