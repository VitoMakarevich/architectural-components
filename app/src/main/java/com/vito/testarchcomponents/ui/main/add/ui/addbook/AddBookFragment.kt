package com.vito.testarchcomponents.ui.main.add.ui.addbook

import android.app.ListActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.vito.testarchcomponents.MainActivity
import com.vito.testarchcomponents.R
import com.vito.testarchcomponents.common.Status
import com.vito.testarchcomponents.components.Resource
import com.vito.testarchcomponents.databinding.AddBookFragmentBinding
import com.vito.testarchcomponents.model.Book

class AddBookFragment : Fragment() {

    companion object {
        fun newInstance() = AddBookFragment()
    }

    private lateinit var viewModel: AddBookViewModel

    private lateinit var buttonAdd: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding: AddBookFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.add_book_fragment, container, false)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)

        val view = binding.root

        buttonAdd = view.findViewById(R.id.addBookButton)
        buttonAdd.setOnClickListener { viewModel.addBook() }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(AddBookViewModel::class.java)

        viewModel.addRequest.observe(activity!!,  Observer<Book> {
            startActivity(Intent(activity, MainActivity::class.java))
        })


    }

}
