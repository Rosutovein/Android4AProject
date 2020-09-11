package com.rosutovein.android4aproject.injection

import com.rosutovein.android4aproject.MainViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory{ MainViewModel() }
}

