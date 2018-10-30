package com.vito.testarchcomponents.ui.main.viewTabs.list

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.transition.Visibility
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
    private lateinit var errorSnackbar: Snackbar
    private lateinit var loading: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.book_list_fragment, container, false)

        recyclerView = view.findViewById(R.id.bookListRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        errorSnackbar = Snackbar.make(view.rootView, "Unknown error", Snackbar.LENGTH_INDEFINITE)

        loading = view.findViewById(R.id.loading)

        return view
    }

    private fun loadBooks() {
        viewModel.loadBooks()
        recyclerView.visibility = View.INVISIBLE
        loading.visibility = View.VISIBLE

        viewModel.books.observe(this,  Observer<List<Book>> {
            books ->
                loading.visibility = View.INVISIBLE
                recyclerView.visibility = View.VISIBLE
                books?.let { recyclerView.adapter = BookListAdapter(books) }
        })

        viewModel.booksErrors.observe(this,  Observer<String> {
            loading.visibility = View.INVISIBLE

            errorSnackbar.setAction("Retry") { loadBooks() }
            errorSnackbar.show()
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BookListViewModel::class.java)
        loadBooks()
    }

}
