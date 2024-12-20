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
import com.buzzware.athleteedge.databinding.ItemDesignTopSearchLayoutBinding

class TopSearchAdapter(val context: Context, private val list: ArrayList<String>)
    : RecyclerView.Adapter<TopSearchAdapter.ViewHolder>() {

    private val selectedPositions = mutableSetOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDesignTopSearchLayoutBinding.inflate(LayoutInflater.from(context), parent, false) )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.binding.root.text = list[position]

        if (selectedPositions.contains(position)) {
            holder.binding.root.setBackgroundResource(R.drawable.rounded_blue_bg)
            holder.binding.root.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.blue))
        } else {
            holder.binding.root.setBackgroundResource(R.drawable.rounded_edittext_bg)
            holder.binding.root.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.gray_100))
        }

        holder.itemView.setOnClickListener {
            if (selectedPositions.contains(position)) {
                selectedPositions.remove(position)
            } else {
                selectedPositions.add(position)
            }
            notifyItemChanged(position)
        }

    }

    class ViewHolder(val binding : ItemDesignTopSearchLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}