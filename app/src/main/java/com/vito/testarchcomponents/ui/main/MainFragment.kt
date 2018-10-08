package com.vito.testarchcomponents.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vito.testarchcomponents.R
import com.vito.testarchcomponents.model.Book

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var textView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        textView = view.findViewById<TextView>(R.id.message)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getUsers().observe(this, Observer<List<Book>> {
            books ->
            textView.text = books?.get(0)?.name
        })

        return view
    }

}
