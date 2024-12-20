package com.buzzware.athleteedge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buzzware.athleteedge.classes.CourseOverviewModel
import com.buzzware.athleteedge.databinding.ItemDesignCourseOverviewBinding
import com.buzzware.athleteedge.databinding.ItemDesignCoursesLayoutBinding

class CourseOverviewAdapter(val context: Context, private val list: ArrayList<CourseOverviewModel>)
    : RecyclerView.Adapter<CourseOverviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDesignCourseOverviewBinding.inflate(LayoutInflater.from(context), parent, false) )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]

        holder.binding.titleTV.text = model.title
        holder.binding.noteTV.text = model.note

    }

    class ViewHolder(val binding : ItemDesignCourseOverviewBinding) : RecyclerView.ViewHolder(binding.root)

}