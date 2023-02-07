package com.example.profile


import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import com.google.gson.Gson
import java.io.ByteArrayOutputStream


class SharedPrefs(context: Context) {
    private val fileName: String = "sharedPreferences"
    private val prefs : SharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    fun getSharedPrefObj(): SharedPreferences {
        return prefs
    }

    fun getPrefs(){
        val person = Gson().fromJson(prefs.getString("person",null),PersonData::class.java)
        Person.getPerson(person)


//        Person.personData.fname = prefs.getString("fname",null)
//        Person.personData.lname = prefs.getString("lname",null)
//        Person.personData.fatherName = prefs.getString("fatherName",null)
//        Person.personData.phone = prefs.getString("cnumber",null)
//        Person.personData.gender = prefs.getString("gender",null)
//        Person.personData.email = prefs.getString("email",null)
//        Person.personData.password = prefs.getString("password",null)
//        Person.personData.hDegree = prefs.getString("degree",null)
//        Person.personData.pYear = prefs.getString("year","")
//        Person.personData.grades = prefs.getString("grades",null)
//        Person.personData.institute = prefs.getString("institute",null)
////        Person.image = prefs.getString("image", null)
//        Person.personData.image= stringToBitMap(prefs.getString("image",null))
//        if(prefs.getString("imageUri",null)==null){
//            Person.personData.imageUri = null
//        }else {
//            Person.personData.imageUri = Uri.parse(prefs.getString("imageUri", null))
//        }
    }

    fun setPrefs(){
        val person:PersonData = Person.setPerson(Person)
        with(prefs.edit()){
            val personData = Gson().toJson(person)
//            println(person.get(0))
            putString("person",personData)
            apply()


//            putString("fname",Person.personData.fname)
//            putString("lname",Person.personData.lname)
//            putString("fatherName",Person.personData.fatherName)
//            putString("gender",Person.personData.gender)
//            putString("cnumber",Person.personData.phone)
//            putString("email",Person.personData.email)
//            putString("password",Person.personData.password)
//            putString("degree",Person.personData.hDegree)
//            putString("year",Person.personData.pYear)
//            putString("grades",Person.personData.grades)
//            putString("institute",Person.personData.institute)
////            putString("image", Person.image.toString())
//            putString("image", Person.personData.image?.let { BitMapToString(it) })
//            putString("imageUri",Person.personData.imageUri.toString())
//            apply()
        }
    }

}