package com.example.quizapp.share

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R

class QuizAdapter(private val quizList: ArrayList<com.example.quizapp.models.Question>,
                  val listener: onItemDetailClickListener):
    RecyclerView.Adapter<QuizAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.quiz_item,parent,false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = quizList[position]
        holder._question.setText(currentItem.text)
        holder.correctAnswer.setText(currentItem.answers[0])
        holder.delete.setOnClickListener { deleteItem(position) }

    }

    override fun getItemCount() = quizList.size

    inner class ExampleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener{
        override fun onClick(v: View?) {
            val position= adapterPosition
            if(position!=-1){
                listener.onItemClick(position)
            }
        }

        val _question: TextView = itemView.findViewById(R.id.quizQuestion)
        val correctAnswer: TextView = itemView.findViewById(R.id.correctAnswer)
        val delete: TextView = itemView.findViewById(R.id.delete)
        val details: TextView = itemView.findViewById(R.id.details)

        init {
            details.setOnClickListener(this)
        }
    }

    fun deleteItem(position: Int){
        quizList.removeAt(position)
        notifyDataSetChanged()
    }
    interface onItemDetailClickListener{
        fun onItemClick(position: Int)
    }
}