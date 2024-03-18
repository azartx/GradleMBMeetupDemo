package com.solo4.gradlembmeetupdemo.presentation.screens.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.solo4.gradlembmeetupdemo.R
import com.solo4.gradlembmeetupdemo.databinding.FragmentFriendsBinding
import com.solo4.gradlembmeetupdemo.presentation.screens.friends.model.FriendModel

class FriendsFragment : Fragment() {

    private var binding: FragmentFriendsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFriendsBinding.inflate(layoutInflater, container, false).run {
            binding = this
            root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycler()
    }

    private fun setupRecycler() {
        binding?.recyclerFriends?.adapter = FriendsAdapter(::onFriendClick)
    }

    private fun onFriendClick(friend: FriendModel) {
        val message = getString(R.string.friends_friend_click_toast, friend.fullName)
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}