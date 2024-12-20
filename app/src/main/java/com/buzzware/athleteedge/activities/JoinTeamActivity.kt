package com.buzzware.athleteedge.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.buzzware.athleteedge.R
import com.buzzware.athleteedge.databinding.ActivityJoinTeamBinding

class JoinTeamActivity : AppCompatActivity() {

    private val binding : ActivityJoinTeamBinding by lazy{
        ActivityJoinTeamBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        setListener()

    }

    private fun setListener() {
        binding.joinTeamTV.setOnClickListener {
            startActivity(Intent(this, TeamNotFoundActivity::class.java))
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