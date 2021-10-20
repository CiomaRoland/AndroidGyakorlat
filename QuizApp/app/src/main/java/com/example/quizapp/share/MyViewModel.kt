package com.example.quizapp.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.models.Question

class QuizViewModel : ViewModel() {
    private val questions: MutableLiveData<List<Question>> by lazy {
        MutableLiveData<List<Question>>().also {
            loadQuestion()
        }
    }

    fun getQuestion(): LiveData<List<Question>> {
        return questions
    }

    private fun loadQuestion() {

    }
}