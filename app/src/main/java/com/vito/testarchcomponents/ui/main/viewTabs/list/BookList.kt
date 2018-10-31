package com.vito.testarchcomponents.ui.main.viewTabs.list

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
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
import com.vito.testarchcomponents.ui.main.add.AddBook
import java.util.logging.Logger

class BookList : Fragment() {

    companion object {
        fun newInstance() = BookList()
    }

    private lateinit var viewModel: BookListViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var errorSnackbar: Snackbar
    private lateinit var addBook: FloatingActionButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.book_list_fragment, container, false)

        recyclerView = view.findViewById(R.id.bookListRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        errorSnackbar = Snackbar.make(view.rootView, "Unknown error", Snackbar.LENGTH_INDEFINITE)

        addBook = view.findViewById(R.id.addBookFab)
        addBook.setOnClickListener{
            val intent = Intent(activity, AddBook::class.java)
            startActivity(intent)
        }

        return view
    }

    private fun loadBooks() {
        viewModel.loadBooks()

        viewModel.books.observe(this,  Observer<List<Book>> {
            books ->
                books?.let { recyclerView.adapter = BookListAdapter(books) }
        })

        viewModel.booksErrors.observe(this,  Observer<String> {

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
