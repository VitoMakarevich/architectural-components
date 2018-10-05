package com.vito.testarchcomponents.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.vito.testarchcomponents.BookApplication
import com.vito.testarchcomponents.model.Book
import com.vito.testarchcomponents.repositories.BookRepository
import rx.Subscriber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainViewModel : ViewModel() {

    @Inject
    lateinit var bookRepository: BookRepository

    init {
        BookApplication.bookRepositoryComponent.inject(this)
    }


    private lateinit var books: MutableLiveData<List<Book>>




    fun getUsers(): LiveData<List<Book>> {
        if (!::books.isInitialized) {
            books = MutableLiveData()
            loadUsers()
        }
        return books
    }

    private fun loadUsers() {
        bookRepository.loadBooks().subscribe(
            object : Subscriber<List<Book>>() {
                override fun onCompleted() {
                }

                override fun onError(e: Throwable?) {
                }

                override fun onNext(t: List<Book>?) {
                    books.postValue(t)
                }
            }
        )
    }
}
