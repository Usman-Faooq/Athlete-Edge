package com.buzzware.athleteedge.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.buzzware.athleteedge.R
import com.buzzware.athleteedge.adapters.SearchDetailAdapter
import com.buzzware.athleteedge.classes.FeaturedCoursesModel
import com.buzzware.athleteedge.databinding.ActivitySearchDetailBinding

class SearchDetailActivity : AppCompatActivity(), SearchDetailAdapter.OnSearchItem {

    private val binding : ActivitySearchDetailBinding by lazy {
        ActivitySearchDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setAdapter()
        setListener()
    }

    private fun setAdapter() {

        val array = arrayListOf(
            FeaturedCoursesModel("Basketball Dribbling Skills", "Learn advanced dribbling techniques to enhance your control and speed on the court."),
            FeaturedCoursesModel("Yoga for Athletes", "Improve your mental strength and flexibility with these yoga exercises tailored for athletes."),
            FeaturedCoursesModel("Soccer Shooting Techniques", "Master the art of shooting with precision and power with these comprehensive tutorials."),
            FeaturedCoursesModel("Basketball Dribbling Skills", "Learn advanced dribbling techniques to enhance your control and speed on the court."),
            )

        binding.searchRV.layoutManager = LinearLayoutManager(this)
        binding.searchRV.adapter = SearchDetailAdapter(this, array, this)

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

    override fun onItemClicked() {
        startActivity(Intent(this, CourseDetailActivity::class.java))
        overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }

}