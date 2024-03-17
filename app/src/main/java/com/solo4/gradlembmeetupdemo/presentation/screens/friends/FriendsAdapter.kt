package com.solo4.gradlembmeetupdemo.presentation.screens.friends

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.solo4.gradlembmeetupdemo.databinding.ItemFriendBinding
import com.solo4.gradlembmeetupdemo.presentation.screens.friends.model.FriendModel

class FriendsAdapter : RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>() {

    private val items = mutableListOf<FriendModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        return FriendsViewHolder(
            binding = ItemFriendBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        holder.bind(items.getOrNull(position) ?: return)
    }

    class FriendsViewHolder(private val binding: ItemFriendBinding) : ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: FriendModel) {
            binding.textviewFriendName.text = "${item.firstName} ${item.lasName}"
            binding.textviewFriendSubtitle.text = item.subtitle
        }
    }
}