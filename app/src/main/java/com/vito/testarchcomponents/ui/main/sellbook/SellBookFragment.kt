package com.vito.testarchcomponents.ui.main.sellbook

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vito.testarchcomponents.MainActivity
import com.vito.testarchcomponents.R
import com.vito.testarchcomponents.common.Status
import com.vito.testarchcomponents.components.Resource
import com.vito.testarchcomponents.model.Book

class SellBookFragment : Fragment() {

    companion object {
        fun newInstance(id: String): SellBookFragment {
            val fragment = SellBookFragment()
            val args = Bundle()
            args.putString(SellBookFragment.id, id)
            fragment.arguments = args

            return fragment
        }
        const val id = "com.vito.testarchcomponents.ui.main.sellbook.fragment.id"
    }

    private lateinit var viewModel: SellBookViewModel
    private lateinit var id: String

    private lateinit var nameTextView: TextInputEditText
    private lateinit var descriptionTextView: TextInputEditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.sell_book_fragment, container, false)

        nameTextView = view.findViewById(R.id.viewSellBookNameTextView)
        descriptionTextView = view.findViewById(R.id.viewSellBookDescriptionTextView)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.id = arguments?.getString(SellBookFragment.id).toString()

        viewModel = ViewModelProviders.of(this).get(SellBookViewModel::class.java)

        viewModel.book.observe(this,  Observer<Book> {
            if (it != null) {
                nameTextView.setText(it.name)
                descriptionTextView.setText(it.description)
            }
        })

        viewModel.loadBook(id)
    }

}
