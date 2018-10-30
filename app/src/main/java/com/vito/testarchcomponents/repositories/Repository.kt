package com.vito.testarchcomponents.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.vito.testarchcomponents.api.BooksApi
import com.vito.testarchcomponents.model.Book
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class Repository(val api: BooksApi) {


    fun loadBooksSell(): Single<List<Book>> {
        return api.getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun createBookSell(book: Book): Single<Book> {
        return api.createSellBook(book)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun loadSellBook(id: String): Single<Book> {
        return api.getSellBook(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}