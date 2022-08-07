package com.agesadev.telmed.presentation.patientprofile

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.agesadev.telmed.R
import com.agesadev.telmed.databinding.FragmentPatientDetailsBinding
import com.agesadev.telmed.databinding.FragmentPatientProfileBinding
import com.agesadev.telmed.presentation.detail.PatientListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PatientProfileFragment : Fragment() {

    private var _binding: FragmentPatientProfileBinding? = null
    private val binding get() = _binding

    private val patientArgs: PatientProfileFragmentArgs by navArgs()


    private val patientListViewModel: PatientProfileViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPatientProfileBinding.inflate(inflater, container, false)
        binding?.apply {
            patientAge.text = patientArgs.patientData?.date_of_birth + " Years old"
            patientNameCard.text =
                "${patientArgs.patientData?.first_name} + ${patientArgs.patientData?.last_name}"
            patientNameHeader.text =
                "${patientArgs.patientData?.first_name} + ${patientArgs.patientData?.last_name}"
        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}