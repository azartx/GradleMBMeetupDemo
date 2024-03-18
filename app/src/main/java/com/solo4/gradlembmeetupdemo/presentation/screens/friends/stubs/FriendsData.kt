package com.solo4.gradlembmeetupdemo.presentation.screens.friends.stubs

import com.solo4.gradlembmeetupdemo.presentation.screens.friends.model.FriendModel

private val firstNames = listOf(
    "David",
    "James",
    "Ron",
    "Elizabeth",
    "Carl",
    "Lisa",
    "Lory",
    "Jake",
    "Dolph"
)

private val lastNames = listOf(
    "Kolins",
    "Kramn",
    "Ginger",
    "Hopes",
    "Oconal",
    "Hermit",
    "Bones",
    "Tramp",
    "Alper"
)

private val subtitles = listOf(
    "Software Engineer",
    "Head of sales",
    "Junior Android Developer",
    "Software Engineer",
    "Head of sales",
    "Junior Android Developer",
    "Software Engineer",
    "Head of sales",
    "Junior Android Developer"
)

val friends = List(10) {
    FriendModel(
        firstName = firstNames.random(),
        lastName = lastNames.random(),
        subtitle = subtitles.random()
    )
}