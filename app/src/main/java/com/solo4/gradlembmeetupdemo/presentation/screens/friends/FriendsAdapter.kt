package com.solo4.gradlembmeetupdemo.presentation.screens.friends

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.solo4.gradlembmeetupdemo.databinding.ItemFriendBinding
import com.solo4.gradlembmeetupdemo.presentation.screens.friends.model.FriendModel
import com.solo4.gradlembmeetupdemo.presentation.screens.friends.stubs.friends

class FriendsAdapter(
    private val onItemClick: (FriendModel) -> Unit
) : RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>(), OnClickListener {

    private val items = friends

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        return FriendsViewHolder(
            binding = ItemFriendBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ).apply { root.setOnClickListener(this@FriendsAdapter) }
        )
    }
    override fun onClick(v: View?) {
        v?.tag?.let { viewTag ->
            if (viewTag is FriendModel) {
                onItemClick.invoke(viewTag)
            }
        }
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
            binding.root.tag = item

            binding.textviewFriendName.text = item.fullName
            binding.textviewFriendSubtitle.text = item.subtitle
        }
    }
}