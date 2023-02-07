package com.example.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Profile.newInstance] factory method to
 * create an instance of this fragment.
 */
class Profile : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        var view = inflater.inflate(R.layout.fragment_profile, container, false)
        view.findViewById<TextView>(R.id.name_value).setText(Person.getFullName())
        view.findViewById<TextView>(R.id.father_value).setText(Person.personData.fatherName)
        view.findViewById<TextView>(R.id.gender_value).setText(Person.personData.gender)
        view.findViewById<TextView>(R.id.cnumber_value).setText(Person.personData.phone)
        view.findViewById<TextView>(R.id.email_value).setText(Person.personData.email)
        view.findViewById<TextView>(R.id.father_value).setText(Person.personData.fatherName)
        view.findViewById<TextView>(R.id.password_value).setText(Person.personData.password)
        view.findViewById<TextView>(R.id.hdegree_value).setText(Person.personData.hDegree)
        view.findViewById<TextView>(R.id.grades_value).setText(Person.personData.grades)
        if(Person.personData.pYear.toString()!=null){
            view.findViewById<TextView>(R.id.year_value).setText(Person.personData.pYear.toString())
        }
        view.findViewById<TextView>(R.id.institute_value).setText(Person.personData.institute)
        if(view.findViewById<ImageView>(R.id.profile_image)!=null){
            Glide.with(this)
                .load(Person.imageUri)
                .fitCenter()
                .centerCrop()
                .transform(CircleCrop())
                .placeholder(R.drawable.ic_baseline_account_circle_24)
                .into(view.findViewById(R.id.profile_image))
        //            view.findViewById<ImageView>(R.id.profile_image).setImageBitmap(MainActivity.Person.image)
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
         * @return A new instance of fragment Profile.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Profile().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}