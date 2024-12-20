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
import com.buzzware.athleteedge.activities.ProActivity
import com.buzzware.athleteedge.adapters.CategoriesAdapter
import com.buzzware.athleteedge.adapters.CoursesAdapter
import com.buzzware.athleteedge.adapters.FeaturedCoursesAdapter
import com.buzzware.athleteedge.classes.FeaturedCoursesModel
import com.buzzware.athleteedge.classes.ProgressCoursesModel
import com.buzzware.athleteedge.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), FeaturedCoursesAdapter.OnItemClicked, CoursesAdapter.OnCourseClicked {

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private lateinit var fragmentContext : Context

    interface OnFragmentButtonClicked {
        fun viewAllVideoClicked()
        fun viewProgressCourses()
    }

    private var listener: OnFragmentButtonClicked? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        setAdapter()
        setListener()

        return binding.root
    }

    private fun setListener() {

        binding.viewAllCoursesTV.setOnClickListener {
            listener!!.viewAllVideoClicked()
        }

        binding.viewProgressTV.setOnClickListener {
            listener!!.viewProgressCourses()
        }

    }

    private fun setAdapter() {

        val featureArray = arrayListOf(
            FeaturedCoursesModel("Missing the shot", "John Eames"),
            FeaturedCoursesModel("Agile Project", "Curt Rits"))
        binding.featuredRV.layoutManager = LinearLayoutManager(fragmentContext, LinearLayoutManager.HORIZONTAL, false)
        binding.featuredRV.adapter = FeaturedCoursesAdapter(fragmentContext, featureArray, this)

        binding.categoryRV.layoutManager = LinearLayoutManager(fragmentContext, LinearLayoutManager.HORIZONTAL, false)
        binding.categoryRV.adapter = CategoriesAdapter(fragmentContext, arrayListOf("Self Talk", "Glasses", "Goal", "Database"))

        binding.coursesRV.layoutManager = LinearLayoutManager(fragmentContext)
        binding.coursesRV.adapter = CoursesAdapter(fragmentContext, arrayListOf(ProgressCoursesModel("Mental Toughness 101", "Clara Manning", 69)), this)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentContext = context

        if (context is OnFragmentButtonClicked) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnButtonClickListener")
        }
    }

    override fun onProClicked(s1: String) {
        startActivity(Intent(fragmentContext, ProActivity::class.java))
        requireActivity().overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }

    override fun onItemClicked() {
        startActivity(Intent(fragmentContext, CourseDetailActivity::class.java))
        requireActivity().overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }

}