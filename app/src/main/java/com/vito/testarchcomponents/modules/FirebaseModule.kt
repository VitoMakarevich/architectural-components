package com.vito.testarchcomponents.modules

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FirebaseModule() {

    @Provides
    fun firebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
}