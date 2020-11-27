package com.rosutovein.android4aproject.domain.useCase

import com.rosutovein.android4aproject.data.repository.UserRepository
import com.rosutovein.android4aproject.domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}