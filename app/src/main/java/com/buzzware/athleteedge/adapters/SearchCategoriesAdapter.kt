package com.buzzware.athleteedge.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.buzzware.athleteedge.R
import com.buzzware.athleteedge.databinding.ItemDesignCategoryLayoutBinding
import com.buzzware.athleteedge.databinding.ItemDesignCoursesLayoutBinding
import com.buzzware.athleteedge.databinding.ItemDesignSearchCategoryLayoutBinding

class SearchCategoriesAdapter(val context: Context, private val list: ArrayList<String>)
    : RecyclerView.Adapter<SearchCategoriesAdapter.ViewHolder>() {

    private var selectedPosition = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDesignSearchCategoryLayoutBinding.inflate(LayoutInflater.from(context), parent, false) )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.binding.checkBox.text = list[position]


    }

    class ViewHolder(val binding : ItemDesignSearchCategoryLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}