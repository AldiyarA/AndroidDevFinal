package com.example.Final.di

import com.example.Final.api.CountryClient
import com.example.Final.repository.CountryRepository
import com.example.Final.view_models.CountryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CountryViewModel(get()) }
}

val repositoryModule = module {
    single { CountryRepository(get()) }
}

val networkModule = module {
    single { CountryClient.create() }
}