package com.example.quizapp.share

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.quizapp.R
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import com.example.quizapp.models.Question

class QuizViewModel(application: Application): AndroidViewModel(application) {

    private var playerName : String? ="Roland"
    private var currenQuestionNumber = 0
    private var questions: ArrayList<Question> = arrayListOf()
    private var numberOfCorrectQuestion = 0
    private var highScore = 0
    private lateinit var questionDetail: Question

    private val context = getApplication<Application>().applicationContext

    init {
        loadQuestions()
    }
    fun setPlayerName(name: String){
        playerName=name
    }
    fun getPlayerName():String?{
        return playerName
    }
    private fun loadQuestions(){
        val isReader: InputStream = context.resources.openRawResource(R.raw.questions)
        val reader = BufferedReader(InputStreamReader(isReader))
        val lines = reader.readLines()
        for (i in 0..lines.size-2 step 5){
            questions.add(Question(lines[i], mutableListOf(lines[i+1],lines[i+2],lines[i+3],lines[i+4])))
        }
    }
    fun getHighScore():Int{
        return highScore
    }
    fun resetQuestions(){
        currenQuestionNumber=0
        numberOfCorrectQuestion=0
        questions.shuffle()
    }
    fun getCurrentQuestion():Question{
        return questions[currenQuestionNumber]
    }
    fun questionsSize():Int{
        return questions.size
    }
    fun getNumberOfCorrectAnswer():Int{
        return numberOfCorrectQuestion
    }
    fun getCurrenQuestionNumber():Int{
        return currenQuestionNumber
    }
    fun incCurrentQuestionNumber(){
        ++currenQuestionNumber
    }
    fun incNumberOfCorrectQuestion(){
        ++numberOfCorrectQuestion
        if(numberOfCorrectQuestion>highScore){
            highScore=numberOfCorrectQuestion
        }
    }
    fun addNewQuestion(question: Question){
        questions.add(question)
    }
    fun getQuestionList():ArrayList<Question>{
        return questions
    }
    fun setQuestionDetail(question: Question){
        questionDetail=question
    }
    fun getQuestionDetail(): Question{
        return questionDetail
    }
}