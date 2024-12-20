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
import com.buzzware.athleteedge.databinding.ActivityTeamNotFoundBinding

class TeamNotFoundActivity : AppCompatActivity() {

    private val binding : ActivityTeamNotFoundBinding by lazy {
        ActivityTeamNotFoundBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Delay for 4 seconds before moving to the next activity
        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this, SignInActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
            overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
                androidx.appcompat.R.anim.abc_fade_out)

        }, 3000) // 4000 milliseconds = 4 seconds

    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }
}