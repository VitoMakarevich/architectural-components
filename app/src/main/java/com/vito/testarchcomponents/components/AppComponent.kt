package com.vito.testarchcomponents.components

import android.content.Context
import com.vito.testarchcomponents.modules.ContextModule
import com.vito.testarchcomponents.modules.RepositoryModule
import com.vito.testarchcomponents.repositories.Repository
import com.vito.testarchcomponents.ui.main.viewTabs.BookTabsPagerAdapter
import com.vito.testarchcomponents.ui.main.viewTabs.MainViewModel
import com.vito.testarchcomponents.ui.main.viewTabs.list.BookListViewModel
import dagger.Component

@Component(modules = [RepositoryModule::class, ContextModule::class])
interface AppComponent {
    fun getRepository(): Repository

    fun getContext(): Context

    fun inject(tabsPagerAdapter: BookTabsPagerAdapter)
    fun inject(bookListViewModel: BookListViewModel)
}