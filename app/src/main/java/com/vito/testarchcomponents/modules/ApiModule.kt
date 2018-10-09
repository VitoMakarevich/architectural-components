package com.vito.testarchcomponents.modules

import com.vito.testarchcomponents.api.BooksApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [RetrofitModule::class])
class ApiModule {

    @Provides
    fun provideApiModule(retrofit: Retrofit): BooksApi {
        return retrofit.create<BooksApi>(BooksApi::class.java)
    }
}