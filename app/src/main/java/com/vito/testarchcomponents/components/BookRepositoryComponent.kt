package com.vito.testarchcomponents.components

import com.vito.testarchcomponents.modules.BookRepositoryModule
import com.vito.testarchcomponents.repositories.BookRepository
import com.vito.testarchcomponents.ui.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [BookRepositoryModule::class])
interface BookRepositoryComponent {
    fun inject(mainViewModel: MainViewModel)
}