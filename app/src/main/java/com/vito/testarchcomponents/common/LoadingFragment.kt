package com.vito.testarchcomponents.common

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.vito.testarchcomponents.R

class LoadingFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = LoadingFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_loading, container, false)
    }
}
