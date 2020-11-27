package com.rosutovein.android4aproject.injection

import android.content.Context
import androidx.room.Room
import com.rosutovein.android4aproject.data.local.AppDatabase
import com.rosutovein.android4aproject.data.local.DatabaseDao
import com.rosutovein.android4aproject.data.repository.UserRepository
import com.rosutovein.android4aproject.domain.useCase.CreateUserUseCase
import com.rosutovein.android4aproject.domain.useCase.GetUserUseCase
import com.rosutovein.android4aproject.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module {
    factory{ MainViewModel(get(), get()) }
}

val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }

}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDatabase(androidContext()) }
    }

fun createDatabase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}



