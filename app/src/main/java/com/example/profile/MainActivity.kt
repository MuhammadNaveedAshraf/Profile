package com.example.profile

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private val fragmentManager = supportFragmentManager
    lateinit var sharedPrefs: SharedPrefs
    var currentActiveButton:Int =R.id.info_button
//    val person:Person = Person.getPerson()
    fun personalInfo(view: View){
        val fragment = PersonalInformation()
        val newBtn = R.id.info_button
        activateButton(newBtn)
        replaceFragment(fragment,newBtn,"info")
    }
    fun eduction(view: View){
        val newBtn = R.id.edu_button
        activateButton(newBtn)
        replaceFragment(Education(),newBtn,"edu")
    }
    fun image(view: View){
        val newBtn = R.id.image_button
        activateButton(newBtn)
        replaceFragment(Image(),newBtn,"img")
    }
    fun profile(view: View){
        val newBtn = R.id.profile_button
        activateButton(newBtn)
        replaceFragment(Profile(),newBtn,"profile")
    }
    fun replaceFragment(fragment: Fragment, newBtn:Int,tag:String){
        if(newBtn!=currentActiveButton){
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainerView,fragment, tag)
            fragmentTransaction.addToBackStack(tag)
            fragmentTransaction.commit()
            currentActiveButton = newBtn
        }
    }
    fun activateButton(buttonId:Int){
        val newBtn: Button = findViewById(buttonId)
        if(currentActiveButton!=-1){
            val currentBtn: Button = findViewById(currentActiveButton)
//            currentBtn.setTextColor(Color.WHITE)
//            currentBtn.setBackgroundColor(getResources().getColor(R.color.dark_red))
            currentBtn.background = resources.getDrawable(R.drawable.button_inactive)
        }
        newBtn.background = resources.getDrawable(R.drawable.button_active)
//        newBtn.setBackgroundColor(Color.GRAY)
//        newBtn.setTextColor(Color.BLACK)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPrefs = SharedPrefs(applicationContext)
        sharedPrefs.getPrefs()

    }


    override fun onPause() {
        sharedPrefs = SharedPrefs(applicationContext)
        sharedPrefs.setPrefs()
        super.onPause()
    }
}