package com.vito.testarchcomponents.ui.main.add.ui.addbook

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vito.testarchcomponents.R

class AddBookFragment : Fragment() {

    companion object {
        fun newInstance() = AddBookFragment()
    }

    private lateinit var viewModel: AddBookViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.add_book_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddBookViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
