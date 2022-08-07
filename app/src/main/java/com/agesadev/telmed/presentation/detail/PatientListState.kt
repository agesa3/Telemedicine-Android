package com.agesadev.telmed.presentation.detail

import com.agesadev.telmed.domain.model.Patient

data class PatientListState(
    val isLoading: Boolean = false,
    val data: List<Patient> = emptyList(),
    val error: String = ""
)

