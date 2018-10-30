package com.vito.testarchcomponents.ui.main.viewTabs

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vito.testarchcomponents.R
import com.vito.testarchcomponents.model.Book
import com.vito.testarchcomponents.ui.main.add.AddBook

class MainFragment : Fragment() {

    private lateinit var tabs: TabLayout
    private lateinit var tabsPager: ViewPager
    private lateinit var addBook: FloatingActionButton

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        tabs = view.findViewById(R.id.booksTabs)
        tabsPager = view.findViewById(R.id.bookTabsPager)
        addBook = view.findViewById(R.id.addBookFab)

        val tabsFragmentAdapter = BookTabsPagerAdapter(activity!!.supportFragmentManager)
        tabsPager.adapter = tabsFragmentAdapter
        tabs.setupWithViewPager(tabsPager)
        addBook.setOnClickListener(){
            val intent = Intent(activity, AddBook::class.java)
            startActivity(intent)
        }

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        return view
    }

}
