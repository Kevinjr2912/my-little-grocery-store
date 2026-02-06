package com.softgenix.miabarrotito.features.auth.di

import com.softgenix.miabarrotito.core.di.AppContainer
import com.softgenix.miabarrotito.features.auth.domain.usecases.LoginUseCase
import com.softgenix.miabarrotito.features.auth.domain.usecases.RegisterUseCase
import com.softgenix.miabarrotito.features.auth.presentation.viewmodels.LoginViewModelFactory
import com.softgenix.miabarrotito.features.auth.presentation.viewmodels.RegisterViewModelFactory

class AuthModule(private val appContainer: AppContainer) {

    private fun provideRegisterUseCase(): RegisterUseCase {
        return RegisterUseCase(appContainer.authRepository)
    }

    fun provideRegisterViewModelFactory(): RegisterViewModelFactory {
        return RegisterViewModelFactory(
            registerUseCase = provideRegisterUseCase()
        )
    }


    private fun provideLoginUseCase(): LoginUseCase {
        return LoginUseCase(appContainer.authRepository)
    }

    fun provideLoginViewModelFactory(): LoginViewModelFactory {
        return LoginViewModelFactory(
            loginUseCase = provideLoginUseCase()
        )
    }

}