package com.example.popularlibraries.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popularlibraries.R
import moxy.MvpAppCompatFragment

open class ProgressFragment: MvpAppCompatFragment() {

    protected fun changeViewVisibility(view: View, tumbler: Boolean) {
        view.visibility = if (tumbler) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

}