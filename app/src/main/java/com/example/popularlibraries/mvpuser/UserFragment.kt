package com.example.popularlibraries.mvpuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.example.popularlibraries.databinding.ViewUserBinding

class UserFragment : MvpAppCompatFragment(), UserView {

    private var _binding: ViewUserBinding? = null
    private val binding get() = _binding!!

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = ViewUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            sendButton.setOnClickListener {
                presenter.register(
                    inputEditLogin.text.toString(),
                    inputEditPassword.text.toString()
                )
            }
        }
    }

    companion object {
        fun newInstance() = UserFragment()
    }

    override fun showError(message: String) {
        Toast.makeText(context, "$message", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}