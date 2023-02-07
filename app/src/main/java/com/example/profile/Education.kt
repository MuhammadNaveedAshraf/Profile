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
 * Use the [Education.newInstance] factory method to
 * create an instance of this fragment.
 */
class Education : Fragment() {
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
        val hdegree = view?.findViewById<EditText>(R.id.degree_editText)
        val year = view?.findViewById<EditText>(R.id.year_et)
        val grades = view?.findViewById<EditText>(R.id.grade_editText)
        val institute = view?.findViewById<EditText>(R.id.institute_et)

        Person.personData.hDegree = hdegree?.text.toString()
        Person.personData.pYear = year?.text.toString()
        Person.personData.grades = grades?.text.toString()
        Person.personData.institute = institute?.text.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_education, container, false)
        view.findViewById<EditText>(R.id.degree_editText).setText(Person.personData.hDegree)
        view.findViewById<EditText>(R.id.grade_editText).setText(Person.personData.grades)
        if(Person.personData.pYear.toString()!=null){
            view.findViewById<EditText>(R.id.year_et).setText(Person.personData.pYear.toString())
        }
        view.findViewById<EditText>(R.id.institute_et).setText(Person.personData.institute)

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Education.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Education().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}