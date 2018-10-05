package com.vito.testarchcomponents

import android.app.Application
import com.vito.testarchcomponents.components.ApplicationComponent
import com.vito.testarchcomponents.components.BookRepositoryComponent
//import com.vito.testarchcomponents.components.DaggerApplicationComponent
import com.vito.testarchcomponents.components.DaggerBookRepositoryComponent
import com.vito.testarchcomponents.modules.ApplicationModule
import com.vito.testarchcomponents.modules.BookRepositoryModule
import com.vito.testarchcomponents.repositories.BookRepository

class BookApplication: Application() {

    companion object {
        lateinit var bookRepositoryComponent: BookRepositoryComponent
//        lateinit var  applicationComponent: ApplicationComponent
    }


    override fun onCreate() {
        super.onCreate()

        initDagger(this)
    }

    private fun initDagger(application: BookApplication) {
//        applicationComponent = DaggerApplicationComponent
//                .builder()
//                .applicationModule(ApplicationModule(application))
//                .build()

        bookRepositoryComponent = DaggerBookRepositoryComponent
                .builder()
                .bookRepositoryModule(BookRepositoryModule())
                .build()


    }
}