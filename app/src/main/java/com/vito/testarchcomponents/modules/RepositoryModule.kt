package com.vito.testarchcomponents.modules

import com.vito.testarchcomponents.api.BooksApi
import com.vito.testarchcomponents.repositories.Repository
import dagger.Module
import dagger.Provides

@Module(includes = [ApiModule::class])
class RepositoryModule {

    @Provides
    fun provideRepository(api: BooksApi): Repository {
        return Repository(api)
    }
}