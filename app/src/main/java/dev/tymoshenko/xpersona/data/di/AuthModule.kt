package dev.tymoshenko.xpersona.data.di

import dev.tymoshenko.xpersona.ui.screens.auth.AuthViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel<AuthViewModel> { AuthViewModel(get()) }
}