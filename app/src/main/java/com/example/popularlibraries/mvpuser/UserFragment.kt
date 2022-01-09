package com.example.popularlibraries.mvpuser

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.example.popularlibraries.data.GitHubUserDetail
import com.example.popularlibraries.data.GitHubUsersRepositoryFactory
import com.example.popularlibraries.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.bumptech.glide.request.target.Target

class UserFragment(login: String) : MvpAppCompatFragment(), UserView {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    private val presenter by moxyPresenter {
        UserPresenter(login, GitHubUsersRepositoryFactory.create())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance(login: String) =
            UserFragment(login)
    }

    override fun showUserDetail(user: GitHubUserDetail) {
        binding.fragmentUserLoginTextView.text = user.login
        binding.fragmentUserTypeTextView.text = user.type
        binding.fragmentUserSysAdminTextView.text = user.sysAdmin.toString()

        context?.let {
            Glide.with(it)
                .load(user.url)
                .listener(getGlideListener())
                .into(binding.fragmentUserAvatarImageView)
        }
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun getGlideListener() = object : RequestListener<Drawable> {
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean,
        ): Boolean {
            Toast.makeText(context, e?.message.toString(), Toast.LENGTH_SHORT).show()
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean,
        ): Boolean {
            binding.fragmentUserAvatarProgressBar.visibility = View.GONE
            return false
        }
    }
}