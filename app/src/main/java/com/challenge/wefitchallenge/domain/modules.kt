package com.challenge.wefitchallenge.domain

import com.challenge.wefitchallenge.data.PersistenceManager
import com.challenge.wefitchallenge.presentation.home.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {
        viewModel { MainViewModel() }
}

var persistenceModule = module {
        single { PersistenceManager(androidContext()) }
}
