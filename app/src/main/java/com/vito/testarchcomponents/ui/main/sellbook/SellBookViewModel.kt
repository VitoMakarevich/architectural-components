package com.vito.testarchcomponents.ui.main.sellbook

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.vito.testarchcomponents.BookApplication
import com.vito.testarchcomponents.components.AppComponent
import com.vito.testarchcomponents.model.Book
import com.vito.testarchcomponents.repositories.Repository
import javax.inject.Inject

class SellBookViewModel : ViewModel() {
    val book = MutableLiveData<Book>()
    val bookError = MutableLiveData<String>()

    init {
        BookApplication.appComponent.inject(this)
    }

    @Inject
    lateinit var repository: Repository

    fun loadBook(id: String) {
        repository.loadSellBook(id)
            .subscribe(
                {book.value = it},
                {bookError.value = it.message}
            )
    }
}
