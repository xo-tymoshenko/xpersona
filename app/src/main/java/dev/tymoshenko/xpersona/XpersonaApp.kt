package dev.tymoshenko.xpersona

import android.app.Application
import android.content.Context
import dev.tymoshenko.xpersona.data.di.xpersonaModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class XpersonaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        configureKoin(this)
    }

    private fun configureKoin(ctx: Context) {
        startKoin {
            androidLogger()
            androidContext(ctx)
            modules(xpersonaModule)
        }
    }
}