package com.buzzware.athleteedge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buzzware.athleteedge.R
import com.buzzware.athleteedge.classes.DummyModels
import com.buzzware.athleteedge.classes.ProgressCoursesModel
import com.buzzware.athleteedge.databinding.ItemDesignCoursesLayoutBinding
import com.buzzware.athleteedge.databinding.ItemDesignSavedCoursesLayoutBinding
import com.buzzware.athleteedge.databinding.ItemDesignTeamLayoutBinding

class TeamAdapter(val context: Context, private val list: ArrayList<DummyModels>, private val listener : OnTeamItemClicked)
    : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    interface OnTeamItemClicked {
        fun onRemoveClicked()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDesignTeamLayoutBinding.inflate(LayoutInflater.from(context), parent, false) )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model = list[position]

        holder.binding.titleTV.text = model.name

        if (model.name == "Basketball Team"){
            holder.binding.imageView4444.setImageResource(R.drawable.ic_basketball)
        }else if (model.name == "Soccer Team"){
            holder.binding.imageView4444.setImageResource(R.drawable.ic_football)
        }

        if (model.check){
            holder.binding.removeTV.visibility = View.VISIBLE
        }else{
            holder.binding.removeTV.visibility = View.GONE
        }

       holder.binding.removeTV.setOnClickListener {
           listener.onRemoveClicked()
       }

    }

    class ViewHolder(val binding : ItemDesignTeamLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}