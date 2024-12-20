package com.buzzware.athleteedge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buzzware.athleteedge.classes.ProgressCoursesModel
import com.buzzware.athleteedge.databinding.ItemDesignCoursesLayoutBinding

class CoursesAdapter(val context: Context, private val list: ArrayList<ProgressCoursesModel>, private val listener: OnCourseClicked)
    : RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {

    interface OnCourseClicked{
        fun onItemClicked()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDesignCoursesLayoutBinding.inflate(LayoutInflater.from(context), parent, false) )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model = list[position]

        holder.binding.nameTV.text = model.title
        holder.binding.noteTV.text = model.note
        holder.binding.progressSlider.progress = model.progress
        holder.binding.progressTV.text = "${model.progress}% Complete"
        holder.binding.progressSlider.isEnabled = false

        holder.binding.root.setOnClickListener {
            listener.onItemClicked()
        }

    }

    class ViewHolder(val binding : ItemDesignCoursesLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}