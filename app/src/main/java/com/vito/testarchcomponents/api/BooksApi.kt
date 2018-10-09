package com.vito.testarchcomponents.api

import android.database.Observable
import com.vito.testarchcomponents.model.Book
import io.reactivex.Single
import retrofit2.http.GET

interface BooksApi {
    @GET("books")
    fun getBooks(): Single<List<Book>>
}