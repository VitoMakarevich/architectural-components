package com.vito.testarchcomponents.components

import com.vito.testarchcomponents.modules.ApplicationModule
import com.vito.testarchcomponents.ui.main.MainViewModel
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
//    fun inject(mainViewModel: MainViewModel)
}