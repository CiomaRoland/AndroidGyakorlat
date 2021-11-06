package com.example.quizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.models.Question
import com.example.quizapp.share.QuizViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionAdd.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionAdd : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var questionPlaceholder: EditText
    private lateinit var answerInput1: EditText
    private lateinit var answerInput2: EditText
    private lateinit var answerInput3: EditText
    private lateinit var answerInput4: EditText
    private lateinit var addQuestion: Button

    private val model: QuizViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_question_add, container, false)
        view?.apply {
            initializeView(this)
            registerListeners()
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuestionAdd.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuestionAdd().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun registerListeners(){
        addQuestion.setOnClickListener(){
            val question = Question(questionPlaceholder.text.toString(),
                mutableListOf(answerInput1.text.toString(),answerInput2.text.toString(),
                    answerInput3.text.toString(),answerInput4.text.toString()))
            model.addNewQuestion(question)
            findNavController().navigate(R.id.action_questionAdd_self)
        }
        answerInput1.addTextChangedListener {
            inputEmpty()
        }
        answerInput2.addTextChangedListener {
            inputEmpty()
        }
        answerInput3.addTextChangedListener {
            inputEmpty()
        }
        answerInput4.addTextChangedListener {
            inputEmpty()
        }
        questionPlaceholder.addTextChangedListener {
            inputEmpty()
        }
    }

    private fun initializeView(view: View){
        questionPlaceholder = view.findViewById(R.id.questionPlaceholder)
        answerInput1=view.findViewById(R.id.answerInput1)
        answerInput2=view.findViewById(R.id.answerInput2)
        answerInput3=view.findViewById(R.id.answerInput3)
        answerInput4=view.findViewById(R.id.answerInput4)
        addQuestion=view.findViewById(R.id.addQuestion)
    }
    private fun inputEmpty(){
        if(answerInput1.text.toString()!="" && answerInput2.text.toString()!="" &&
            answerInput3.text.toString()!="" && answerInput4.text.toString()!="" &&
            questionPlaceholder.text.toString()!=""){
            addQuestion.isEnabled=true
        }else{
            addQuestion.isEnabled=false
        }
    }
}