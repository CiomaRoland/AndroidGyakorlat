package com.example.quizapp.ui

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.share.QuizViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Question.newInstance] factory method to
 * create an instance of this fragment.
 */
class Question : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    //
    private lateinit var questionStr: TextView
    private lateinit var radioGroupAnswers: RadioGroup
    private lateinit var answer1: RadioButton
    private lateinit var answer2: RadioButton
    private lateinit var answer3: RadioButton
    private lateinit var answer4: RadioButton
    private lateinit var nextBtn: Button

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
        val view = inflater.inflate(R.layout.fragment_question, container, false)
        view?.apply {
            initializeView(this)
            setQuestionAndAnswers()
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
         * @return A new instance of fragment Question.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Question().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun registerListeners(){
        answer1.setOnClickListener{
            nextBtn.isEnabled=true
        }
        answer2.setOnClickListener{
            nextBtn.isEnabled=true
        }
        answer3.setOnClickListener{
            nextBtn.isEnabled=true
        }
        answer4.setOnClickListener{
            nextBtn.isEnabled=true
        }
        nextBtn.setOnClickListener(){
            if(answer1.isChecked && model.getCurrentQuestion().answers[0]==answer1.text){
                model.incNumberOfCorrectQuestion()
            }
            if(answer2.isChecked && model.getCurrentQuestion().answers[0]==answer2.text){
                model.incNumberOfCorrectQuestion()
            }
            if(answer3.isChecked && model.getCurrentQuestion().answers[0]==answer3.text){
                model.incNumberOfCorrectQuestion()
            }
            if(answer4.isChecked && model.getCurrentQuestion().answers[0]==answer4.text){
                model.incNumberOfCorrectQuestion()
            }
            model.incCurrentQuestionNumber()
            if(model.getCurrenQuestionNumber()<model.questionsSize()){
                findNavController().navigate(R.id.action_question_self)
            }else{
                findNavController().navigate(R.id.action_question_to_end2)
            }
        }
    }

    private fun initializeView(view: View){
        questionStr = view.findViewById(R.id.questionStr)
        radioGroupAnswers = view.findViewById(R.id.radioGroupAnswers)
        answer1 = view.findViewById(R.id.answer1)
        answer2 = view.findViewById(R.id.answer2)
        answer3 = view.findViewById(R.id.answer3)
        answer4 = view.findViewById(R.id.answer4)
        nextBtn = view.findViewById(R.id.nextBtn)
    }
    private fun setQuestionAndAnswers(){
        val question = model.getCurrentQuestion()
        questionStr.text=question.text
        val answers = mutableListOf<String>()
        for (i in 0..3){
            answers.add(question.answers[i])
        }
        answers.shuffle()
        answer1.text=answers[0]
        answer2.text=answers[1]
        answer3.text=answers[2]
        answer4.text=answers[3]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showDialog(context)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }
    fun showDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Exit")
        builder.setMessage("Are you sure you want to end this quiz?")
        builder.setPositiveButton("Yes",{ dialogInterface: DialogInterface, i: Int ->
            findNavController().navigate(R.id.action_question_to_end2)
        })
        builder.setNegativeButton("No",{ dialogInterface: DialogInterface, i: Int -> })
        val dialog = builder.create()
        dialog.show()
    }
}