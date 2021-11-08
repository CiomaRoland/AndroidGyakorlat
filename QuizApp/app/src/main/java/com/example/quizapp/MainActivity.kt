package com.example.quizapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import com.example.quizapp.share.QuizViewModel

import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model: QuizViewModel by viewModels()
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val navView: NavigationView = findViewById(R.id.nav_View)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.home2)
                R.id.nav_quizTime -> Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.start2)
                R.id.nav_profile -> Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.profile)
                R.id.nav_listOfQuestions -> Navigation.findNavController(
                    this,
                    R.id.nav_host_fragment
                ).navigate(R.id.questionList)
                R.id.nav_newQuestion -> Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.questionAdd)
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}