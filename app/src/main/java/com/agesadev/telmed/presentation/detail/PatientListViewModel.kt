package com.agesadev.telmed.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agesadev.telmed.core.Resource
import com.agesadev.telmed.domain.usecases.GetPatientsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PatientListViewModel @Inject constructor(
    private val patientListUseCase: GetPatientsUseCase
) : ViewModel() {
    private val _patientList = MutableStateFlow(PatientListState())
    val patientList: StateFlow<PatientListState> = _patientList


    init {
        getAllPatients()
    }

    private fun getAllPatients() {
        viewModelScope.launch {
            patientListUseCase().collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        _patientList.value = PatientListState(data = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        _patientList.value =
                            PatientListState(error = result.error ?: "Error getting ships")

                    }
                    is Resource.Loading -> {
                        _patientList.value = PatientListState(isLoading = true)
                    }
                }
            }
        }
    }

}
