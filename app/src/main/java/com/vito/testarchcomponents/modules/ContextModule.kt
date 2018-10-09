package com.vito.testarchcomponents.modules

import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class ContextModule(internal var context: Context) {

    @Provides
    fun context(): Context {
        return context.getApplicationContext()
    }
}