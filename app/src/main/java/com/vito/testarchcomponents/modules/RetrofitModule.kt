package com.vito.testarchcomponents.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [ContextModule::class])
class RetrofitModule {

    @Provides
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory, gson: Gson): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("http://10.0.2.2:8080")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()

        return gsonBuilder.create()
    }

    @Provides
    fun gsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }
}