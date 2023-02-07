package com.example.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PersonalInformation.newInstance] factory method to
 * create an instance of this fragment.
 */
class PersonalInformation : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
//    var localPerson:Person = Person()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onPause() {
        super.onPause()
        val fname = view?.findViewById<EditText>(R.id.fname_editText)
        val lname = view?.findViewById<EditText>(R.id.lname_editText)
        val fatherName = view?.findViewById<EditText>(R.id.father_name_et)
        val gender = view?.findViewById<EditText>(R.id.gender_et)
        val contact = view?.findViewById<EditText>(R.id.cnumber_et)
        val email = view?.findViewById<EditText>(R.id.email_et)
        val password = view?.findViewById<EditText>(R.id.password_et)


        Person.personData.fname = fname?.text.toString()
        Person.personData.lname = lname?.text.toString()
        Person.personData.fatherName = fatherName?.text.toString()
        if(gender?.text.toString()!=null && gender?.text.toString()!=""){
            Person.personData.gender = gender?.text.toString()}
        Person.personData.phone = contact?.text.toString()
        Person.personData.email = email?.text.toString()
        Person.personData.password = password?.text.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_personal_information, container, false)
        view.findViewById<EditText>(R.id.fname_editText).setText(Person.personData.fname)
        view.findViewById<EditText>(R.id.lname_editText).setText(Person.personData.lname)
        view.findViewById<EditText>(R.id.father_name_et).setText(Person.personData.fatherName)
        view.findViewById<EditText>(R.id.gender_et).setText(Person.personData.gender)
        view.findViewById<EditText>(R.id.cnumber_et).setText(Person.personData.phone)
        view.findViewById<EditText>(R.id.email_et).setText(Person.personData.email)
        view.findViewById<EditText>(R.id.password_et).setText(Person.personData.password)
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PersonalInformation.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PersonalInformation().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}