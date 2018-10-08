package com.vito.testarchcomponents

//import com.vito.testarchcomponents.components.DaggerApplicationComponent
import android.app.Application
import com.vito.testarchcomponents.components.AppComponent
import com.vito.testarchcomponents.components.DaggerAppComponent
import com.vito.testarchcomponents.modules.RepositoryModule
import com.vito.testarchcomponents.repositories.Repository

class BookApplication: Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }


    override fun onCreate() {
        super.onCreate()

        initDagger(this)
    }

    private fun initDagger(application: BookApplication) {
        appComponent = DaggerAppComponent
            .builder()
            .repositoryModule(RepositoryModule())
            .build()
    }
}