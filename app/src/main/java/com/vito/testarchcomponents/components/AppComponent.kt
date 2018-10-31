package com.vito.testarchcomponents.components

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.vito.testarchcomponents.modules.ContextModule
import com.vito.testarchcomponents.modules.FirebaseModule
import com.vito.testarchcomponents.modules.RepositoryModule
import com.vito.testarchcomponents.repositories.Repository
import com.vito.testarchcomponents.ui.main.add.ui.addbook.AddBookViewModel
import com.vito.testarchcomponents.ui.main.sellbook.SellBookViewModel
import com.vito.testarchcomponents.ui.main.viewTabs.list.BookListViewModel
import dagger.Component

@Component(modules = [RepositoryModule::class, ContextModule::class, FirebaseModule::class])
interface AppComponent {
    fun getRepository(): Repository

    fun getContext(): Context

    fun getFirebaseAuth(): FirebaseAuth
    fun inject(bookListViewModel: BookListViewModel)
    fun inject(addBookViewModel: AddBookViewModel)
    fun inject(viewSellBookViewModel: SellBookViewModel)
}