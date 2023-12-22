package com.sulitsa.dev.ledgerlink.di

import com.sulitsa.dev.ledgerlink.di.module.ContextModule
import com.sulitsa.dev.ledgerlink.di.module.DatabaseModule
import com.sulitsa.dev.ledgerlink.di.module.RepositoryModule
import com.sulitsa.dev.ledgerlink.presentation.home.HomeScreen
import com.sulitsa.dev.ledgerlink.presentation.info.AccountNumberInfoScreen
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ContextModule::class,
    DatabaseModule::class,
    RepositoryModule::class
])
interface AppComponent {
    fun inject(homeScreen: HomeScreen)
    fun inject(homeScreen: AccountNumberInfoScreen)
}