package com.example.profile

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import java.io.ByteArrayOutputStream

object Person{
        var image: Bitmap?=null
        var imageUri:Uri?=null
        var personData = PersonData()
        fun getPerson(personData:PersonData):Person{
                Person.image = personData.image?.let { stringToBitmap(it) }
                Person.imageUri = Uri.parse(personData.imageUri)
                Person.personData = personData
                return Person
        }
        fun setPerson(person: Person):PersonData{
                var personData:PersonData = PersonData()
                personData.fname = person.personData.fname
                personData.lname =person.personData.lname
                personData.fatherName=person.personData.fatherName
                personData.gender = person.personData.gender
                personData.phone = person.personData.phone
                personData.email = person.personData.email
                personData.password = person.personData.password
                personData.hDegree = person.personData.hDegree
                personData.grades = person.personData.grades
                personData.pYear = person.personData.pYear
                personData.institute = person.personData.institute
                personData.imageUri = person.imageUri.toString()
                personData.image = person.image?.let { BitMapToString(it)}
                return personData

        }

        fun getFullName():String{
                return String.format("%s %s", personData.fname, personData.lname)
        }
        fun BitMapToString(bitmap: Bitmap): String {
                val baos = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
                val b = baos.toByteArray()
                return Base64.encodeToString(b, Base64.DEFAULT)
        }
        fun stringToBitmap(string:String):Bitmap?{
                return try {
                        val imageBytes =Base64.decode(string,0);
                        val image= BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size);
                        image;
                } catch(e:Exception ) {
                        e.message;
                        null;
                }
        }
}