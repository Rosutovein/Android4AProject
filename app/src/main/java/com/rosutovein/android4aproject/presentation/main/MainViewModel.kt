package com.rosutovein.android4aproject.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rosutovein.android4aproject.domain.entity.User
import com.rosutovein.android4aproject.domain.useCase.CreateUserUseCase
import com.rosutovein.android4aproject.domain.useCase.GetUserUseCase
import kotlinx.coroutines.*
import org.koin.ext.getScopeName

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser, password)
            val loginStatus = if(user != null && user.email != "" && user.password != ""){
                LoginSuccess(user.email, user.password)
            }
            else{
                LoginError
            }
            //Notification à ma vue du changement (hors du thread)
            withContext(Dispatchers.Main) {
                loginLiveData.value = loginStatus
            }
        }
    }

    fun onClickedCreateAccount(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if(emailUser!="" && password!="")
                createUserUseCase.invoke(User(emailUser, password))
        }
    }
}