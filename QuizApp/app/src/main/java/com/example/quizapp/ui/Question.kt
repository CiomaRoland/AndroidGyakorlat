package com.example.quizapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R

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
    private lateinit var questions: TextView
    //radioButtons
    private lateinit var answer1:RadioButton
    private lateinit var answer2:RadioButton
    private lateinit var answer3:RadioButton
    private lateinit var answer4:RadioButton
    //
    private lateinit var nextBtn: Button

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
            registerListeners()
        }
        return view
    }
    private fun initializeView(view: View){
        questions = view.findViewById(R.id.questions)
        answer1=view.findViewById(R.id.answer1)
        answer2=view.findViewById(R.id.answer2)
        answer3=view.findViewById(R.id.answer3)
        answer4=view.findViewById(R.id.answer4)
        nextBtn = view.findViewById(R.id.nextBtn)
    }
    private fun registerListeners(){
        nextBtn.setOnClickListener(){
            findNavController().navigate(R.id.action_question_to_end2)
        }
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
}