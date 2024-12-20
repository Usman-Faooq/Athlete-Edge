package com.buzzware.athleteedge.activities

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.buzzware.athleteedge.R
import com.buzzware.athleteedge.databinding.ActivityDashBoardBinding
import com.buzzware.athleteedge.fragments.CoursesFragment
import com.buzzware.athleteedge.fragments.HomeFragment
import com.buzzware.athleteedge.fragments.ProfileFragment
import com.buzzware.athleteedge.fragments.SavedFragment
import com.buzzware.athleteedge.fragments.SearchFragment

class DashBoardActivity : AppCompatActivity(), HomeFragment.OnFragmentButtonClicked {

    private val binding : ActivityDashBoardBinding by lazy {
        ActivityDashBoardBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setView()
        setHomeTab()
        setListener()

    }

    private fun setView() {

    }

    private fun setListener() {

        binding.homeLL.setOnClickListener {
            setHomeTab()
        }

        binding.searchLL.setOnClickListener {
            setSearchTab()
        }

        binding.courseLL.setOnClickListener {
            setCoursesTab()
        }

        binding.saveLL.setOnClickListener {
            setSaveTab()
        }

        binding.profileLL.setOnClickListener {
            setProfileTab()
        }

    }

    private fun setHomeTab(){
        binding.homeIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.blue))
        binding.homeTV.setTextColor(ContextCompat.getColor(this, R.color.blue))

        binding.searchIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.searchTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.courseIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.courseTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.saveIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.saveTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.profileIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.profileTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))

        binding.homeAppBar.visibility = View.VISIBLE
        binding.searchAppBar.visibility = View.GONE
        binding.appBar.visibility = View.GONE

        loadFragment(HomeFragment())
    }

    private fun setSearchTab(){
        binding.searchIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.blue))
        binding.searchTV.setTextColor(ContextCompat.getColor(this, R.color.blue))

        binding.homeIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.homeTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.courseIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.courseTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.saveIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.saveTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.profileIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.profileTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))


        binding.homeAppBar.visibility = View.GONE
        binding.searchAppBar.visibility = View.VISIBLE
        binding.appBar.visibility = View.GONE

        loadFragment(SearchFragment())
    }

    private fun setCoursesTab(){
        binding.courseIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.blue))
        binding.courseTV.setTextColor(ContextCompat.getColor(this, R.color.blue))

        binding.searchIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.searchTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.homeIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.homeTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.saveIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.saveTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.profileIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.profileTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))


        binding.homeAppBar.visibility = View.GONE
        binding.searchAppBar.visibility = View.GONE
        binding.appBar.visibility = View.VISIBLE
        binding.titleTV.text = "Courses"
        binding.ivState.visibility = View.VISIBLE
        binding.ivFilter.visibility = View.GONE

        loadFragment(CoursesFragment())
    }

    private fun setSaveTab(){
        binding.saveIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.blue))
        binding.saveTV.setTextColor(ContextCompat.getColor(this, R.color.blue))

        binding.searchIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.searchTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.courseIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.courseTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.homeIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.homeTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.profileIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.profileTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))


        binding.homeAppBar.visibility = View.GONE
        binding.searchAppBar.visibility = View.GONE
        binding.appBar.visibility = View.VISIBLE
        binding.titleTV.text = "Saved Courses"
        binding.ivState.visibility = View.GONE
        binding.ivFilter.visibility = View.GONE

        loadFragment(SavedFragment())
    }

    private fun setProfileTab(){
        binding.profileIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.blue))
        binding.profileTV.setTextColor(ContextCompat.getColor(this, R.color.blue))

        binding.searchIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.searchTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.courseIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.courseTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.saveIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.saveTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.homeIV.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.bottom_tint))
        binding.homeTV.setTextColor(ContextCompat.getColor(this, R.color.bottom_tint))


        binding.homeAppBar.visibility = View.GONE
        binding.searchAppBar.visibility = View.GONE
        binding.appBar.visibility = View.VISIBLE
        binding.titleTV.text = "Profile"
        binding.ivState.visibility = View.GONE
        binding.ivFilter.visibility = View.VISIBLE

        loadFragment(ProfileFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(androidx.appcompat.R.anim.abc_fade_in, com.google.android.material.R.anim.abc_fade_out)
        transaction.replace(binding.container.id, fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }

    override fun viewAllVideoClicked() {
        setSaveTab()
    }

    override fun viewProgressCourses() {
        setCoursesTab()
    }

}