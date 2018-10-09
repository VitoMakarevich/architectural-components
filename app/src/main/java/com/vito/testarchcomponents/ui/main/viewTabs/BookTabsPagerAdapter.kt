package com.vito.testarchcomponents.ui.main.viewTabs

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.vito.testarchcomponents.BookApplication
import com.vito.testarchcomponents.R
import com.vito.testarchcomponents.model.BookTypes
import com.vito.testarchcomponents.ui.main.viewTabs.list.BookList
import javax.inject.Inject



class BookTabsPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    @Inject
    lateinit var context: Context

    init {
        BookApplication.appComponent.inject(this)
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            BookTypes.BUY.position -> {
                BookList()
            }
            else -> {
                BookList()
            }
        }
    }

    companion object {
        val titlesMap = mapOf(
                BookTypes.BUY.position to R.string.Buy,
                BookTypes.EXCHANGE.position to R.string.Exchange,
                BookTypes.SELL.position to R.string.Sell
        )
    }

    override fun getCount(): Int {
        return BookTypes.values().size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.getString(titlesMap[position]!!)
    }
}