package com.vito.testarchcomponents.components

import com.vito.testarchcomponents.modules.RepositoryModule
import com.vito.testarchcomponents.repositories.Repository
import com.vito.testarchcomponents.ui.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RepositoryModule::class])
interface AppComponent {
    fun getRepository(): Repository

    fun inject(mainViewModel: MainViewModel)
}