package com.example.play.store.reproduction.application

import android.app.Application
import com.example.play.store.reproduction.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class PlayStoreReproductionApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        GlobalContext.startKoin {
            androidContext(this@PlayStoreReproductionApplication)
            modules(
                AppModule.create(),
            )
        }
    }
}
