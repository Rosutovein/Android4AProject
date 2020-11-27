package com.rosutovein.android4aproject.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rosutovein.android4aproject.domain.entity.User
import com.rosutovein.android4aproject.domain.useCase.CreateUserUseCase
import com.rosutovein.android4aproject.domain.useCase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val counter: MutableLiveData<Int> = MutableLiveData()
    init {
        counter.value = 0
    }
    fun onClickedIncrement(emailUser: String) {
        GlobalScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(User("test"))
            delay(1000)
            val user = getUserUseCase.invoke("test")
            val debuf = "fdf"
        }
    }
}