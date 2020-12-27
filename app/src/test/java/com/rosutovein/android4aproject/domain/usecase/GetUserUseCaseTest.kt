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
    fun `invoke with invalid email`() {
        runBlocking {
            //GIVEN
            val email = ""
            //Quand tu vas appeler cette méthode, tu ne fais rien
            coEvery{userRepository.getUser(email)} returns null

            //WHEN
            val result = classUnderTest.invoke(email)

            //THEN
            coVerify(exactly = 1) { userRepository.getUser(email) }
            assertEquals(result, null)
        }
    }

    @Test
    fun `invoke with valid email`() {
        runBlocking {
            //GIVEN
            val email = "a@a.c"
            val expectedUser = User("a@a.c")
            coEvery{userRepository.getUser(email)} returns expectedUser

            //WHEN
            val result = classUnderTest.invoke(email)

            //THEN
            coVerify(exactly = 1) { userRepository.getUser(email) }
            assertEquals(result, expectedUser)
        }
    }
}
