package com.vito.testarchcomponents.ui.main.sellbook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.vito.testarchcomponents.R

class SellBookActivity : AppCompatActivity() {

    companion object {
        val ARG_ID = "com.vito.testarchcomponents.ui.main.sellbook.bookId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sell_book_activity)

        val bookId = intent.getStringExtra(ARG_ID)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SellBookFragment.newInstance(bookId))
                    .commitNow()
        }
    }

}
