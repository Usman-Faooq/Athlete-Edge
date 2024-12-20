package com.buzzware.athleteedge.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.buzzware.athleteedge.R
import com.buzzware.athleteedge.databinding.ActivityEmailConfirmationBinding

class EmailConfirmationActivity : AppCompatActivity() {

    private val binding : ActivityEmailConfirmationBinding by lazy {
        ActivityEmailConfirmationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, JoinTeamActivity::class.java))
            overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
                androidx.appcompat.R.anim.abc_fade_out)
            finish()
        }, 3000)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }
}