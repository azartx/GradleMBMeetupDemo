package com.solo4.gradlembmeetupdemo.presentation.screens.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.solo4.gradlembmeetupdemo.databinding.FragmentFriendsBinding

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
        binding?.recyclerFriends?.adapter = FriendsAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}