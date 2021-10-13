package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import org.w3c.dom.Text

const val TAG: String ="MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var playerName:Text
    private lateinit var startButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
        registerListeners()
    }
    private fun registerListeners(){
        startButton.setOnClickListener(){
            Toast.makeText(applicationContext,"Click",Toast.LENGTH_SHORT)
            Log.v("TAG",playerName.textContent)
        }
    }

    private fun initializeView(){
        playerName = findViewById(R.id.playerNameInput)
        startButton = findViewById(R.id.startButton)
    }
}