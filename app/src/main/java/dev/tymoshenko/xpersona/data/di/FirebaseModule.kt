package dev.tymoshenko.xpersona.data.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.dsl.module

val firebaseModule = module {
    single<FirebaseAuth> { Firebase.auth }
}