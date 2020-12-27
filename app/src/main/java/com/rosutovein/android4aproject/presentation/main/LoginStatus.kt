package com.rosutovein.android4aproject.presentation.main

sealed class LoginStatus
//Quand nous obtenons un succès, nous souhaitons faire passer l'email en parametre (utilisé dans le MainViewModel)
data class LoginSuccess(val email: String) : LoginStatus()

object LoginError : LoginStatus()

