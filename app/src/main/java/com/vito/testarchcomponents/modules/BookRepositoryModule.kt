package com.vito.testarchcomponents.modules

import com.vito.testarchcomponents.repositories.BookRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BookRepositoryModule {

    @Provides
    @Singleton
    fun provideBookRepository(): BookRepository {
        return BookRepository()
    }
}