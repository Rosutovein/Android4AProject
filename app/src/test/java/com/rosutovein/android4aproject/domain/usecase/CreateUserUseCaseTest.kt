package com.rosutovein.android4aproject.domain.usecase

import com.rosutovein.android4aproject.data.repository.UserRepository
import com.rosutovein.android4aproject.domain.entity.User
import com.rosutovein.android4aproject.domain.useCase.CreateUserUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CreateUserUseCaseTest{

    private val userRepository: UserRepository = mockk()
    //Nous injectons le mockk à notre objet de type CreateUserUseCase (class à tester)
    private val classUnderTest = CreateUserUseCase(userRepository)

    @Test
    fun invoke(){
        runBlocking {
            //GIVEN
            val user = User("", "")
            coEvery{userRepository.createUser(user)} returns Unit

            //WHEN
            classUnderTest.invoke(user)

            //THEN
            coVerify(exactly = 1) { userRepository.createUser(user) }
        }
    }
}