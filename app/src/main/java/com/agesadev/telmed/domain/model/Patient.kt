package com.agesadev.telmed.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Patient(
    val date_of_birth: String,
    val first_name: String,
    val gender: String,
    val id: Int,
    val id_birth_cert: String,
    val last_name: String,
    val location: String,
    val profile_image: String
) : Parcelable