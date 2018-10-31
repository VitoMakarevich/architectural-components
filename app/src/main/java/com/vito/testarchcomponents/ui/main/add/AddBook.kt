package com.vito.testarchcomponents.ui.main.add

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.Placeholder
import android.support.design.widget.Snackbar
import android.view.View
import com.vito.testarchcomponents.MainActivity
import com.vito.testarchcomponents.R
import com.vito.testarchcomponents.common.LoadingFragment
import com.vito.testarchcomponents.ui.main.add.ui.addbook.AddBookFragment
import com.vito.testarchcomponents.ui.main.add.ui.addbook.AddBookViewModel

class AddBook : AppCompatActivity() {

    private lateinit var viewModel: AddBookViewModel

    private lateinit var loadingFragment: LoadingFragment
    private lateinit var addBookFragment: AddBookFragment

    private lateinit var errorSnackbar: Snackbar
    private lateinit var placeholder: View

    private fun showError() {
        errorSnackbar = Snackbar.make(findViewById(android.R.id.content), "Error", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry") {viewModel.addBook()}

        errorSnackbar.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_book_activity)


        placeholder = findViewById(R.id.addBookPlaceholder)

        loadingFragment = LoadingFragment.newInstance()
        addBookFragment = AddBookFragment.newInstance()

        viewModel = ViewModelProviders.of(this).get(AddBookViewModel::class.java)

        viewModel.addRequestLoading.observe(this, Observer {
            if(it!!) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.addBookPlaceholder
                            , loadingFragment)
                    .commitNow()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.addBookPlaceholder
                            , addBookFragment)
                    .commitNow()
            }
        })

        viewModel.addRequestError.observe(this, Observer {
             if(it != null)
                 showError()

        })

        viewModel.addRequest.observe(this, Observer {
            startActivity(Intent(this, MainActivity::class.java))

        })

        supportFragmentManager.beginTransaction()
                .replace(R.id.addBookPlaceholder
                    , addBookFragment)
                .commitNow()
    }

}
