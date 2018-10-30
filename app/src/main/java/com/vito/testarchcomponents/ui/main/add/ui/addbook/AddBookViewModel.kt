package com.vito.testarchcomponents.ui.main.add.ui.addbook

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.*
import android.view.View
import com.vito.testarchcomponents.BookApplication
import com.vito.testarchcomponents.common.Status
import com.vito.testarchcomponents.components.Resource
import com.vito.testarchcomponents.model.Book
import com.vito.testarchcomponents.repositories.Repository
import javax.inject.Inject

class AddBookViewModel : ViewModel() {

    @Inject
    lateinit var repository: Repository

    val name = ObservableField<String>()
    val description = ObservableField<String>()

    val addRequest = MutableLiveData<Book>()
    val addRequestError = MutableLiveData<String>()
    val addRequestLoading = MutableLiveData<Boolean>().apply { postValue(false)}

    init {
        BookApplication.appComponent.inject(this)
    }

    fun addBook() {
        val book = Book(name.get()!!, description.get()!!)
        addRequestError.value = null
        addRequestLoading.value = true
        repository.createBookSell(book)
                .subscribe (
                        {
                            addRequest.value = it
                            addRequestLoading.value = false
                        },
                        {
                            addRequestError.value = it.message
                            addRequestLoading.value = false
                        }
        )
    }
}
