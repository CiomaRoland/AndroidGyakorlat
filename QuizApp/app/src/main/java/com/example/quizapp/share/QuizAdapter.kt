package com.example.quizapp.share

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R

class QuizAdapter(private val quizList: ArrayList<com.example.quizapp.models.Question>): RecyclerView.Adapter<QuizAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.quiz_item,parent,false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = quizList[position]
        holder._question.setText(currentItem.text)
        holder.correctAnswer.setText(currentItem.answers[0])
    }

    override fun getItemCount() = quizList.size

    class ExampleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val _question: TextView = itemView.findViewById(R.id.quizQuestion)
        val correctAnswer: TextView = itemView.findViewById(R.id.correctAnswer)
    }
}