package com.solo4.gradlembmeetupdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.solo4.gradlembmeetupdemo.presentation.screens.greeting.GreetingFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupGreetingFragment()
    }

    private fun setupGreetingFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_main, GreetingFragment::class.java, null, null)
            .commit()
    }
}