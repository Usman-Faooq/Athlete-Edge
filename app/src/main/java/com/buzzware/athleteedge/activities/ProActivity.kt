package com.buzzware.athleteedge.activities

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.buzzware.athleteedge.R
import com.buzzware.athleteedge.databinding.ActivityProBinding

class ProActivity : AppCompatActivity() {

    private val binding : ActivityProBinding by lazy {
        ActivityProBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setView()
        setListener()

    }

    private fun setView() {

    }

    private fun setListener() {
        val whiteColor = ContextCompat.getColor(this, R.color.white)
        val lightOrange = ContextCompat.getColor(this, R.color.orange_transparent)

        binding.monthLL.setOnClickListener {
            binding.monthLL.backgroundTintList = ColorStateList.valueOf(lightOrange)
            binding.monthLL.elevation = 0F
            binding.yearLL.backgroundTintList = ColorStateList.valueOf(whiteColor)
            binding.yearLL.elevation = 6.5f

        }

        binding.yearLL.setOnClickListener {
            binding.yearLL.backgroundTintList = ColorStateList.valueOf(lightOrange)
            binding.yearLL.elevation = 0F
            binding.monthLL.backgroundTintList = ColorStateList.valueOf(whiteColor)
            binding.monthLL.elevation = 6.5f
        }

        binding.backIV.setOnClickListener {
            finish()
            overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
                androidx.appcompat.R.anim.abc_fade_out)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }
}