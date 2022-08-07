package com.agesadev.telmed.presentation.patientprofile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.agesadev.telmed.R

class PatientProfileFragment : Fragment() {

    companion object {
        fun newInstance() = PatientProfileFragment()
    }

    private lateinit var viewModel: PatientProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_patient_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PatientProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

}