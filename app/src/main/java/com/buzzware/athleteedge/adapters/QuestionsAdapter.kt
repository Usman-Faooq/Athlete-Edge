package com.buzzware.athleteedge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buzzware.athleteedge.classes.QuestionModel
import com.buzzware.athleteedge.databinding.ItemDesignCoursesLayoutBinding
import com.buzzware.athleteedge.databinding.ItemDesignQuestionsLayoutBinding

class QuestionsAdapter(val context: Context, private val list: ArrayList<QuestionModel>)
    : RecyclerView.Adapter<QuestionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDesignQuestionsLayoutBinding.inflate(LayoutInflater.from(context), parent, false) )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model = list[position]

        holder.binding.questionTV.text = "Question ${position + 1}: ${model.question}"
        holder.binding.option1.text = "A. ${model.option1}"
        holder.binding.option2.text = "B. ${model.option2}"
        holder.binding.option3.text = "C. ${model.option3}"
        holder.binding.option4.text = "D. ${model.option4}"

    }

    class ViewHolder(val binding : ItemDesignQuestionsLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}