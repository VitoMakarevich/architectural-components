package com.vito.testarchcomponents.ui.main.add

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.vito.testarchcomponents.R
import com.vito.testarchcomponents.ui.main.add.ui.addbook.AddBookFragment

class AddBook : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_book_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, AddBookFragment.newInstance())
                    .commitNow()
        }
    }

}
