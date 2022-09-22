package com.challenge.wefitchallenge

import com.challenge.wefitchallenge.presentation.home.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {
        viewModel { MainViewModel() }
}