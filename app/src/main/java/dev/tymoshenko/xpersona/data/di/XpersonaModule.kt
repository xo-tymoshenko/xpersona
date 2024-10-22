package dev.tymoshenko.xpersona.data.di

import org.koin.dsl.module

val xpersonaModule = module {
    includes(authModule)
    includes(firebaseModule)
}