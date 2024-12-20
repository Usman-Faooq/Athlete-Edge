package com.buzzware.athleteedge.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.buzzware.athleteedge.R
import com.buzzware.athleteedge.adapters.QuestionsAdapter
import com.buzzware.athleteedge.classes.QuestionModel
import com.buzzware.athleteedge.databinding.ActivityQuestionsBinding

class QuestionsActivity : AppCompatActivity() {

    private val binding : ActivityQuestionsBinding by lazy {
        ActivityQuestionsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setView()
        setListener()

    }

    private fun setView() {

        val array = arrayListOf(
            QuestionModel("What was the takeaway from this video?",
                "You should foul more players", "You should maintain composure",
                "This is not your sport", "Be considerate."),
            QuestionModel("A Second question?",
                "You should foul more players", "You should maintain composure",
                "This is not your sport", "Be considerate."),
        )
        binding.questionsRV.layoutManager = LinearLayoutManager(this)
        binding.questionsRV.adapter = QuestionsAdapter(this, array)

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