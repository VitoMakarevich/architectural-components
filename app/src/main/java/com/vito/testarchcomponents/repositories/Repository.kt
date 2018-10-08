package com.vito.testarchcomponents.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.vito.testarchcomponents.model.Book
import rx.Observable
import rx.lang.kotlin.toObservable
import java.util.concurrent.TimeUnit

class Repository {


    fun loadBooks(): Observable<List<Book>> {

        return Observable
            .range(1, 5)
            .concatMap { i -> Observable.just(i).delay (1000, TimeUnit.MILLISECONDS) }
            .map { i -> Book(i.toInt(), i.toString()) }
            .toList()




    }
}