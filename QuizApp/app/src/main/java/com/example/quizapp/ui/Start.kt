package com.example.quizapp.ui

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizapp.DisplayName
import com.example.quizapp.R
import com.example.quizapp.share.QuizViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
const val TAG: String ="MainActivity"
const val EXTRA_MESSAGE = "name"
/**
 * A simple [Fragment] subclass.
 * Use the [Start.newInstance] factory method to
 * create an instance of this fragment.
 */
class Start : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var startButton: Button
    private lateinit var playerNameInput: EditText
    private lateinit var chooseContact: Button
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
        val view = inflater.inflate(R.layout.fragment_start, container, false)
        view?.apply {
            initializeView(this)
            playerNameInput.setText(model.getPlayerName())
            if (playerNameInput.text.toString() == "") {
                startButton.isEnabled = false
            }
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
         * @return A new instance of fragment Start.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Start().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun registerListeners() {
        startButton.setOnClickListener() {
            model.setPlayerName(playerNameInput.text.toString())
            model.resetQuestions()
            findNavController().navigate(R.id.action_start2_to_question)
        }
        playerNameInput.addTextChangedListener {
            if (playerNameInput.text.toString() != "") {
                startButton.isEnabled = true
            } else {
                startButton.isEnabled = false
            }
        }
        chooseContact.setOnClickListener{
            val intent: Intent = Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI)
            startActivityForResult(intent,28)
        }
    }

    private fun initializeView(view: View) {
        startButton = view.findViewById(R.id.startButton)
        playerNameInput = view.findViewById(R.id.playerNameInput)
        chooseContact = view.findViewById(R.id.chooseContact)
    }
}