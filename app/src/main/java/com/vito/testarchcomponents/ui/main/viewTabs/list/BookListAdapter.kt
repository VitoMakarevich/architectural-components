package com.vito.testarchcomponents.ui.main.viewTabs.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vito.testarchcomponents.model.Book

class BookListAdapter(private val books: List<Book>): RecyclerView.Adapter<BookListAdapter.BookViewHolder>() {
    class BookViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val textView1 = view.findViewById<TextView>(android.R.id.text1)
        private val textView2 = view.findViewById<TextView>(android.R.id.text2)

        fun bindContent(book: Book) {
            textView1.text = book._id
            textView2.text = book.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
               .inflate(android.R.layout.simple_list_item_2, parent, false)



        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]

        holder.bindContent(book)
    }
}