package com.agesadev.telmed.data.remote.dto.patient

import com.agesadev.telmed.domain.model.Patient

data class Data(
    val date_of_birth: String,
    val first_name: String,
    val gender: String,
    val id: Int,
    val id_birth_cert: String,
    val last_name: String,
    val location: String,
    val profile_image: String
)

fun Data.toPatient(): Patient {
    return Patient(
        date_of_birth = date_of_birth,
        first_name = first_name,
        gender = gender,
        id = id,
        id_birth_cert = id_birth_cert,
        last_name = last_name,
        location = location,
        profile_image = profile_image
    )
}

