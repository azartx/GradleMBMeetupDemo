package com.solo4.gradlembmeetupdemo.presentation.screens.greeting

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.solo4.gradlembmeetupdemo.R

class GreetingFragment : Fragment(R.layout.fragment_greeting) {

    private var buttonNext: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        buttonNext = null
    }
}