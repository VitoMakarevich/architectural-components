package com.vito.testarchcomponents.api

import android.database.Observable
import com.vito.testarchcomponents.model.Book
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BooksApi {
    @GET("books")
    fun getBooks(): Single<List<Book>>

    @POST("books")
    fun createSellBook(@Body book: Book): Single<Book>

    @GET("books/{id}")
    fun getSellBook(@Path("id") id: String): Single<Book>
}