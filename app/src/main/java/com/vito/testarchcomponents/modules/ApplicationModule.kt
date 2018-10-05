package com.vito.testarchcomponents.modules

import com.vito.testarchcomponents.BookApplication
import com.vito.testarchcomponents.repositories.BookRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ApplicationModule(val application: BookApplication) {
    @Provides
    @Singleton
    fun provideApplication(): BookApplication = this.application
}