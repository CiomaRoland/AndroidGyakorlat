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
            //Toast.makeText(applicationContext,"Click",Toast.LENGTH_SHORT)
            Log.i("TAG",playerName.toString())

        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"onsStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG,"onRestart()")
    }
    private fun initializeView(){
        playerName = findViewById(R.id.playerNameInput)
        startButton = findViewById(R.id.startButton)
    }
}