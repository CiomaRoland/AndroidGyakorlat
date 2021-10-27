package com.example.quizapp.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.models.Question
import java.io.File

class QuizViewModel : ViewModel() {
    private val fileName="question.txt"
    private val questionList = arrayListOf<Question>()


    private fun loadQuestions() {
        val questionAndAnswer = File(fileName).readLines()
        for(i in 0..questionAndAnswer.size-1 step 5){
            val text = questionAndAnswer[i]
            val answers = listOf<String>(questionAndAnswer[i+1],questionAndAnswer[i+2],questionAndAnswer[i+3],questionAndAnswer[i+4])
            val question = Question(text,answers)
            questionList.add(question)
        }
    }
}