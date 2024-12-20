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
import com.buzzware.athleteedge.activities.SearchDetailActivity
import com.buzzware.athleteedge.adapters.CategoriesAdapter
import com.buzzware.athleteedge.adapters.SearchCategoriesAdapter
import com.buzzware.athleteedge.adapters.TopSearchAdapter
import com.buzzware.athleteedge.databinding.FragmentHomeBinding
import com.buzzware.athleteedge.databinding.FragmentSearchBinding
import com.google.android.flexbox.FlexboxLayoutManager

class SearchFragment : Fragment() {

    private val binding: FragmentSearchBinding by lazy {
        FragmentSearchBinding.inflate(layoutInflater)
    }

    private lateinit var fragmentContext : Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        setAdatper()
        setListener()

        return binding.root
    }

    private fun setListener() {
        binding.showResultTV.setOnClickListener {
            startActivity(Intent(fragmentContext, SearchDetailActivity::class.java))
            requireActivity().overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
                androidx.appcompat.R.anim.abc_fade_out)
        }
    }

    private fun setAdatper() {

        binding.topSearchRV.layoutManager = FlexboxLayoutManager(fragmentContext)
        binding.topSearchRV.adapter = TopSearchAdapter(fragmentContext, arrayListOf("Mindset", "Performance",
            "Missing a shot", "Overtime", "Mental Strength"))

        binding.categorySearchRV.layoutManager = LinearLayoutManager(fragmentContext)
        binding.categorySearchRV.adapter = SearchCategoriesAdapter(fragmentContext, arrayListOf("Goal Setting", "Motivation", "Visualizations", "Self Talk"))

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentContext = context
    }
}