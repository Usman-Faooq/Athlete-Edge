package com.buzzware.athleteedge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buzzware.athleteedge.classes.FeaturedCoursesModel
import com.buzzware.athleteedge.databinding.ItemDesignCoursesLayoutBinding
import com.buzzware.athleteedge.databinding.ItemDesignSearchDetailLayoutBinding

class SearchDetailAdapter(val context: Context, private val list: ArrayList<FeaturedCoursesModel>, private val listener: OnSearchItem)
    : RecyclerView.Adapter<SearchDetailAdapter.ViewHolder>() {

    interface OnSearchItem{
        fun onItemClicked()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDesignSearchDetailLayoutBinding.inflate(LayoutInflater.from(context), parent, false) )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model = list[position]

        holder.binding.nameTV.text = model.title
        holder.binding.priceTV.text = model.name

        holder.binding.root.setOnClickListener {
            listener.onItemClicked()
        }

    }

    class ViewHolder(val binding : ItemDesignSearchDetailLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}