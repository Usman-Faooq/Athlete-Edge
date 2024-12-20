package com.buzzware.athleteedge.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.buzzware.athleteedge.adapters.TeamAdapter
import com.buzzware.athleteedge.classes.DummyModels
import com.buzzware.athleteedge.databinding.ActivityEditProfileBinding
import com.buzzware.athleteedge.databinding.CustomAlertLayoutBinding


class EditProfileActivity : AppCompatActivity(), TeamAdapter.OnTeamItemClicked {

    private val binding : ActivityEditProfileBinding by lazy {
        ActivityEditProfileBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setView()
        setListener()

    }

    private fun setView() {
        binding.currentEmailTV.paintFlags = binding.currentEmailTV.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        binding.teamRV.layoutManager = LinearLayoutManager(this)
        binding.teamRV.adapter = TeamAdapter(this, arrayListOf(
            DummyModels("Basketball Team", true),
            DummyModels("Soccer Team", true)
        ), this)

    }

    private fun setListener() {
        binding.backIV.setOnClickListener {
            finish()
            overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
                androidx.appcompat.R.anim.abc_fade_out)
        }


    }

    private fun showCustomAlert() {
        val dialog = Dialog(this)
        dialog.setCancelable(true)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val dialogBinding = CustomAlertLayoutBinding.inflate(LayoutInflater.from(this))
        dialog.setContentView(dialogBinding.root)
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setGravity(Gravity.CENTER)

        dialogBinding.cancelTV.setOnClickListener {
            dialog.dismiss()
        }

        dialogBinding.yesTV.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }



    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }

    override fun onRemoveClicked() {
        showCustomAlert()
    }
}