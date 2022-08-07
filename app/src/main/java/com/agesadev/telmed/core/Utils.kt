package com.agesadev.telmed.core

import android.os.Build
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Utils {
    const val BASE_URL = "https://desolate-everglades-31375.herokuapp.com/api/"
}

fun returnPatientAge(dateOfBirth: String): String {
    val current = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LocalDateTime.now()
    } else {
        TODO("VERSION.SDK_INT < O")
    }
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return current.format(formatter)
}