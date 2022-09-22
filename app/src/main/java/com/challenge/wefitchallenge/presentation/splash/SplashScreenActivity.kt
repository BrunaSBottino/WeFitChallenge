package com.challenge.wefitchallenge.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.challenge.wefitchallenge.databinding.ActivitySplashscreenBinding
import com.challenge.wefitchallenge.presentation.MainActivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewSplashScreen.animate().alpha(0.0F).setDuration(0)
        binding.textViewSplashScreen.animate().alpha(1.0F).setDuration(3000).withEndAction{
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}