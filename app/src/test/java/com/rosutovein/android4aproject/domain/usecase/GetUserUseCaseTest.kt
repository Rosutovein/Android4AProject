package com.rosutovein.android4aproject.domain.usecase

import com.rosutovein.android4aproject.data.repository.UserRepository
import com.rosutovein.android4aproject.domain.entity.User
import com.rosutovein.android4aproject.domain.useCase.GetUserUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest{

    private val userRepository: UserRepository = mockk()

    //Nous injectons le mockk à notre objet de type GetUserUseCase (class à tester)
    private val classUnderTest = GetUserUseCase(userRepository)

    @Test
    fun `invoke with invalid email and invalid password`() {
        runBlocking {
            //GIVEN
            val email = ""
            val password = ""
            //Quand tu vas appeler cette méthode, tu ne fais rien
            coEvery{userRepository.getUser(email, password)} returns null

            //WHEN
            val result = classUnderTest.invoke(email, password)

            //THEN
            coVerify(exactly = 1) { userRepository.getUser(email, password) }
            assertEquals(result, null)
        }
    }

    @Test
    fun `invoke with valid email`() {
        runBlocking {
            //GIVEN
            val email = "a@a.c"
            val password = "a"
            val expectedUser = User("a@a.c", "a")
            coEvery{userRepository.getUser(email, password)} returns expectedUser

            //WHEN
            val result = classUnderTest.invoke(email, password)

            //THEN
            coVerify(exactly = 1) { userRepository.getUser(email, password) }
            assertEquals(result, expectedUser)
        }
    }
}
