package com.buzzware.athleteedge.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.buzzware.athleteedge.R
import com.buzzware.athleteedge.activities.CourseDetailActivity
import com.buzzware.athleteedge.adapters.CoursesAdapter
import com.buzzware.athleteedge.classes.ProgressCoursesModel
import com.buzzware.athleteedge.databinding.FragmentCoursesBinding
import com.buzzware.athleteedge.databinding.FragmentHomeBinding

class CoursesFragment : Fragment(), CoursesAdapter.OnCourseClicked {

    private val binding: FragmentCoursesBinding by lazy {
        FragmentCoursesBinding.inflate(layoutInflater)
    }

    private lateinit var fragmentContext : Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        setAdapter()

        return binding.root
    }

    private fun setAdapter() {

        val arrayList = arrayListOf(
            ProgressCoursesModel("Mental Toughness 101", "Clara Manning", 69),
            ProgressCoursesModel("Teammates", "Chris Kinley", 27),
            ProgressCoursesModel("Missing the shot", "Lena Gold", 11),
            ProgressCoursesModel("Mental Toughness 201", "Tom Collins", 55),
            ProgressCoursesModel("Practice", "Practice", 35)
        )
        binding.courseRV.layoutManager = LinearLayoutManager(fragmentContext)
        binding.courseRV.adapter = CoursesAdapter(fragmentContext, arrayList, this)

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentContext = context
    }

    override fun onItemClicked() {
        startActivity(Intent(fragmentContext, CourseDetailActivity::class.java))
        requireActivity().overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }
}