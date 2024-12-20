package com.buzzware.athleteedge.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.buzzware.athleteedge.R
import com.buzzware.athleteedge.adapters.CourseOverviewAdapter
import com.buzzware.athleteedge.classes.CourseOverviewModel
import com.buzzware.athleteedge.databinding.ActivityCourseDetailBinding

class CourseDetailActivity : AppCompatActivity() {

    private val binding : ActivityCourseDetailBinding by lazy {
        ActivityCourseDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        setView()
        setListener()

    }

    private fun setView() {
        val array = arrayListOf(
            CourseOverviewModel("Introduction", "Setting the standard"),
            CourseOverviewModel("1. Mental Training #1", "Pre game the mental training"),
            CourseOverviewModel("2. Mental Training #2", "Mid game restructure"),
            CourseOverviewModel("3. Mental Training #3", "Moving along"),
            CourseOverviewModel("Skill test", "1 video"),
        )
        binding.courseOverviewRV.layoutManager = LinearLayoutManager(this)
        binding.courseOverviewRV.adapter = CourseOverviewAdapter(this, array)
    }

    private fun setListener() {

        binding.backIV.setOnClickListener {
            finish()
            overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
                androidx.appcompat.R.anim.abc_fade_out)
        }

        binding.viewAllTV.setOnClickListener {
            startActivity(Intent(this, QuestionsActivity::class.java))
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