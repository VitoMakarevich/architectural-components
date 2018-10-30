package com.vito.testarchcomponents.ui.main.viewTabs.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vito.testarchcomponents.model.Book
import com.vito.testarchcomponents.ui.main.sellbook.SellBookActivity
import com.vito.testarchcomponents.ui.main.sellbook.SellBookFragment

class BookListAdapter(private val books: List<Book>): RecyclerView.Adapter<BookListAdapter.BookViewHolder>() {
    class BookViewHolder(private val view: View, private val context: Context) : RecyclerView.ViewHolder(view) {
        private val textView1 = view.findViewById<TextView>(android.R.id.text1)
        private val textView2 = view.findViewById<TextView>(android.R.id.text2)

        fun bindContent(book: Book) {
            textView1.text = book.name
            textView2.text = book.description

            val intent = Intent(context, SellBookActivity::class.java)
            intent.putExtra(SellBookActivity.ARG_ID, book._id)

            view.setOnClickListener { context.startActivity(intent) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
               .inflate(android.R.layout.simple_list_item_2, parent, false)

        return BookViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bindContent(book)
    }
}