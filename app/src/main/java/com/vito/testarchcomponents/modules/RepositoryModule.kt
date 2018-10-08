package com.vito.testarchcomponents.modules

import com.vito.testarchcomponents.repositories.Repository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(): Repository {
        return Repository()
    }
}