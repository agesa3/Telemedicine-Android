package com.agesadev.telmed.presentation.patientprofile

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.navArgument
import com.agesadev.telmed.databinding.FragmentPatientDetailsBinding
import com.agesadev.telmed.databinding.FragmentPatientProfileBinding
import com.agesadev.telmed.domain.usecases.GetPatientsUseCase
import com.agesadev.telmed.presentation.detail.PatientListAdapter
import com.agesadev.telmed.presentation.detail.PatientListViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PatientProfileViewModel @Inject constructor(
    private val getPatientsUseCase: GetPatientsUseCase
) : ViewModel() {


}
