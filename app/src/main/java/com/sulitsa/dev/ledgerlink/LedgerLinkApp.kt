package com.sulitsa.dev.ledgerlink

import android.app.Application
import com.sulitsa.dev.ledgerlink.di.AppComponent
import com.sulitsa.dev.ledgerlink.di.DaggerAppComponent
import com.sulitsa.dev.ledgerlink.di.module.ContextModule

class LedgerLinkApp : Application() {
    val appComponent: AppComponent = DaggerAppComponent.builder()
        .contextModule(ContextModule(this))
        .build()
}