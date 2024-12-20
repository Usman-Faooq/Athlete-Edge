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

class CategoriesAdapter(val context: Context, private val list: ArrayList<String>)
    : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    private var selectedPosition = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDesignCategoryLayoutBinding.inflate(LayoutInflater.from(context), parent, false) )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.binding.categoryTV.text = list[position]
        if (list[position] == "Self Talk"){
            holder.binding.categoryIV.setImageResource(R.drawable.ic_thumb)
        }else if (list[position] == "Glasses"){
            holder.binding.categoryIV.setImageResource(R.drawable.military_tech)
        }else if (list[position] == "Goal"){
            holder.binding.categoryIV.setImageResource(R.drawable.ic_glasses)
        }else if (list[position] == "Database"){
            holder.binding.categoryIV.setImageResource(R.drawable.ic_db)
        }

        // Highlight the selected date
        if (position == selectedPosition) {
            holder.binding.root.setBackgroundResource(R.drawable.rounded_blue_bg)
            holder.binding.categoryTV.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.blue))
            holder.binding.categoryIV.imageTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.blue))
        } else {
            holder.binding.root.setBackgroundResource(R.drawable.rounded_white_bg)
            holder.binding.categoryTV.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.gray_100))
            holder.binding.categoryIV.imageTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.bottom_tint))
        }

        holder.itemView.setOnClickListener {
            val previousPosition = selectedPosition
            selectedPosition = position

            notifyItemChanged(previousPosition)
            notifyItemChanged(selectedPosition)

        }

    }

    class ViewHolder(val binding : ItemDesignCategoryLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}