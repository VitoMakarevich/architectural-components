package com.vito.testarchcomponents

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.vito.testarchcomponents.ui.main.viewTabs.list.BookList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_activity_layout, BookList.newInstance())
                .commitNow()
        }
    }

}
