package com.sulitsa.dev.ledgerlink.di

import com.sulitsa.dev.ledgerlink.di.module.ContextModule
import com.sulitsa.dev.ledgerlink.di.module.ManagerModule
import com.sulitsa.dev.ledgerlink.presentation.home.HomeScreen
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, ManagerModule::class])
interface AppComponent {
    fun inject(homeScreen: HomeScreen)
}