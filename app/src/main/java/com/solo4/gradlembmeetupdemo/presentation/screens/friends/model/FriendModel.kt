package com.solo4.gradlembmeetupdemo.presentation.screens.friends.model

data class FriendModel(
    val firstName: String,
    val lastName: String,
    val subtitle: String
) {

    val fullName: String = firstName
        .plus(" ")
        .plus(lastName)
}