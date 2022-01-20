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
import com.example.popularlibraries.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.bumptech.glide.request.target.Target
import com.example.popularlibraries.App
import com.example.popularlibraries.data.UserDetail
import com.example.popularlibraries.ui.ProgressFragment

class UserFragment(login: String) : ProgressFragment(), UserView {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    private val presenter by moxyPresenter {
        UserPresenter().apply {
            init(login)
            App.instance.component.provideUserFragmentComponent().build().inject(this)
        }
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

    override fun showUserDetail(user: UserDetail) {
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

    override fun showError(message: String, tumbler: Boolean) {
        changeViewVisibility(binding.userFragmentErrorContainer, tumbler)
        if (tumbler) {
            binding.userFragmentErrorMessage.text = message
            binding.userFragmentTryAgainButton.setOnClickListener {
                presenter.router.exit()
            }
        }
    }

    override fun displayProgress(tumbler: Boolean) {
        changeViewVisibility(binding.userFragmentProgressBar, tumbler)
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