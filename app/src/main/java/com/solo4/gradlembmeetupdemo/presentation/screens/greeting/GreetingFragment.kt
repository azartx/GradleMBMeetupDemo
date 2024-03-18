package com.solo4.gradlembmeetupdemo.presentation.screens.greeting

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.solo4.gradlembmeetupdemo.R
import com.solo4.gradlembmeetupdemo.utils.Route
import com.solo4.gradlembmeetupdemo.utils.navigate

class GreetingFragment : Fragment(R.layout.fragment_greeting) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_next)
            .setOnClickListener { navigate(Route.ProfileRoute) }
    }
}