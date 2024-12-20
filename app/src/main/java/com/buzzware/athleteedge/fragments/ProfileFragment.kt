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
import com.buzzware.athleteedge.activities.EditProfileActivity
import com.buzzware.athleteedge.activities.SignUpActivity
import com.buzzware.athleteedge.activities.StatisticsActivity
import com.buzzware.athleteedge.adapters.TeamAdapter
import com.buzzware.athleteedge.classes.DummyModels
import com.buzzware.athleteedge.databinding.FragmentHomeBinding
import com.buzzware.athleteedge.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(), TeamAdapter.OnTeamItemClicked {

    private val binding: FragmentProfileBinding by lazy {
        FragmentProfileBinding.inflate(layoutInflater)
    }

    private lateinit var fragmentContext : Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        setView()
        setListener()


        return binding.root
    }

    private fun setView() {
        binding.teamRV.layoutManager = LinearLayoutManager(fragmentContext)
        binding.teamRV.adapter = TeamAdapter(fragmentContext, arrayListOf(
            DummyModels("Basketball Team", false),
            DummyModels("Soccer Team", false)), this)
    }

    private fun setListener() {
        binding.viewAllStateTV.setOnClickListener {
            startActivity(Intent(fragmentContext, StatisticsActivity::class.java))
            requireActivity().overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
                androidx.appcompat.R.anim.abc_fade_out)
        }

        binding.editTV.setOnClickListener {
            startActivity(Intent(fragmentContext, EditProfileActivity::class.java))
            requireActivity().overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
                androidx.appcompat.R.anim.abc_fade_out)
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentContext = context
    }

    override fun onRemoveClicked() {

    }


}