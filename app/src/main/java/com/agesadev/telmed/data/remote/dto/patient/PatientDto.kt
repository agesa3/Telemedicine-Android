package com.agesadev.telmed.data.remote.dto.patient

import com.agesadev.telmed.domain.model.Patient

data class PatientDto(
    val id: String,
    val name: String,
    val lastName: String,
    val age: Int,
)

fun PatientDto.toPatient() = Patient(
    id = id,
    name = name,
    lastName = lastName,
    age = age
)
