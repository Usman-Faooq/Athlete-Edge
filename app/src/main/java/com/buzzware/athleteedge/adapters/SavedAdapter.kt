package com.buzzware.athleteedge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buzzware.athleteedge.classes.ProgressCoursesModel
import com.buzzware.athleteedge.databinding.ItemDesignCoursesLayoutBinding
import com.buzzware.athleteedge.databinding.ItemDesignSavedCoursesLayoutBinding

class SavedAdapter(val context: Context, private val list: ArrayList<ProgressCoursesModel>, private val listener : OnProductClicked)
    : RecyclerView.Adapter<SavedAdapter.ViewHolder>() {

    interface OnProductClicked {
        fun onProClicked(tabType: String)
        fun onViewClicked(tabType: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDesignSavedCoursesLayoutBinding.inflate(LayoutInflater.from(context), parent, false) )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model = list[position]

        holder.binding.nameTV.text = model.title
        holder.binding.noteTV.text = model.note

        if (model.progress > 50){
            holder.binding.proTV.visibility = View.VISIBLE
        }else{
            holder.binding.proTV.visibility = View.INVISIBLE
        }

        holder.binding.proTV.setOnClickListener {
            listener.onProClicked("")
        }

        holder.binding.viewTV.setOnClickListener {
            listener.onViewClicked("")
        }

    }

    class ViewHolder(val binding : ItemDesignSavedCoursesLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}