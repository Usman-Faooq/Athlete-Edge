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
import com.buzzware.athleteedge.adapters.CoursesAdapter
import com.buzzware.athleteedge.adapters.SavedAdapter
import com.buzzware.athleteedge.classes.ProgressCoursesModel
import com.buzzware.athleteedge.databinding.FragmentHomeBinding
import com.buzzware.athleteedge.databinding.FragmentSavedBinding

class SavedFragment : Fragment(), SavedAdapter.OnProductClicked {

    private val binding: FragmentSavedBinding by lazy {
        FragmentSavedBinding.inflate(layoutInflater)
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

        binding.saveRV.layoutManager = LinearLayoutManager(fragmentContext)
        binding.saveRV.adapter = SavedAdapter(fragmentContext, arrayList, this)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentContext = context
    }

    override fun onProClicked(tabType: String) {
        startActivity(Intent(fragmentContext, ProActivity::class.java))
        requireActivity().overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }

    override fun onViewClicked(tabType: String) {
        startActivity(Intent(fragmentContext, CourseDetailActivity::class.java))
        requireActivity().overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }
}