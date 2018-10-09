package com.vito.testarchcomponents.ui.main.viewTabs.list

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.vito.testarchcomponents.R
import com.vito.testarchcomponents.model.Book
import com.vito.testarchcomponents.model.BookTypes
import java.util.logging.Logger

class BookList : Fragment() {

    companion object {
        fun newInstance(bookType: BookTypes) = BookList()
    }

    private lateinit var viewModel: BookListViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.book_list_fragment, container, false)

        recyclerView = view.findViewById(R.id.bookListRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BookListViewModel::class.java)
        viewModel.loadBooks()
        viewModel.books.observe(this,  Observer<List<Book>> {
            books -> books?.let { recyclerView.adapter = BookListAdapter(books) }
        })
    }

}
