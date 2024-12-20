package com.buzzware.athleteedge.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.buzzware.athleteedge.R
import com.buzzware.athleteedge.databinding.ActivityStatisticsBinding

class StatisticsActivity : AppCompatActivity() {

    private val binding: ActivityStatisticsBinding by lazy {
        ActivityStatisticsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setListener()


    }

    private fun setListener() {
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