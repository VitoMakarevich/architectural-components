package com.vito.testarchcomponents.ui.main.viewTabs.list

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import android.util.Log
import com.vito.testarchcomponents.BookApplication
import com.vito.testarchcomponents.model.Book
import com.vito.testarchcomponents.model.BookTypes
import com.vito.testarchcomponents.repositories.Repository
import io.reactivex.Observable
import io.reactivex.Single
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class BookListViewModel : ViewModel() {

    @Inject
    lateinit var repository: Repository

    val books: MutableLiveData<List<Book>> by lazy {
        MutableLiveData<List<Book>>()
    }

    val booksErrors: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        BookApplication.appComponent.inject(this)
    }

    fun loadBooks() {
        repository.loadBooksSell()
                .subscribe(
            { books.value = it },
            { booksErrors.value = it.message}
        )
    }
}
