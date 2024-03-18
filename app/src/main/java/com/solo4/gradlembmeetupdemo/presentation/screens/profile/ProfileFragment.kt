package com.solo4.gradlembmeetupdemo.presentation.screens.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.solo4.gradlembmeetupdemo.R
import com.solo4.gradlembmeetupdemo.databinding.FragmentProfileBinding
import com.solo4.gradlembmeetupdemo.presentation.screens.friends.stubs.friends
import com.solo4.gradlembmeetupdemo.utils.Route
import com.solo4.gradlembmeetupdemo.utils.navigate

class ProfileFragment : Fragment() {

    private var binding: FragmentProfileBinding? = null
    private val user = friends.random()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentProfileBinding.inflate(layoutInflater, container, false).run {
            binding = this
            root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupScreenData()
        setupButtonsListeners()
    }

    private fun setupScreenData() {
        binding?.apply {
            textviewUsername.text = user.fullName
            textviewUsernameSubtitle.text = user.subtitle
        }
    }

    private fun setupButtonsListeners() {
        binding?.apply {
            buttonCart.setOnClickListener { showToast(getString(R.string.profile_cart_toast)) }
            buttonNews.setOnClickListener { showToast(getString(R.string.profile_news_toast)) }
            buttonFriends.setOnClickListener { navigate(Route.FriendsRoute) }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}