package com.buzzware.athleteedge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buzzware.athleteedge.classes.FeaturedCoursesModel
import com.buzzware.athleteedge.databinding.ItemDesignCoursesLayoutBinding
import com.buzzware.athleteedge.databinding.ItemDesignFeaturedCoursesBinding

class FeaturedCoursesAdapter(val context: Context, private val list: ArrayList<FeaturedCoursesModel>, private val listener : OnItemClicked)
    : RecyclerView.Adapter<FeaturedCoursesAdapter.ViewHolder>() {

    interface OnItemClicked {
        fun onProClicked(s1: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDesignFeaturedCoursesBinding.inflate(LayoutInflater.from(context), parent, false) )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model = list[position]

        holder.binding.titleTV.text = model.title
        holder.binding.nameTV.text = model.name

        holder.binding.proTV.setOnClickListener {
            listener.onProClicked("")
        }

    }

    class ViewHolder(val binding : ItemDesignFeaturedCoursesBinding) : RecyclerView.ViewHolder(binding.root)

}