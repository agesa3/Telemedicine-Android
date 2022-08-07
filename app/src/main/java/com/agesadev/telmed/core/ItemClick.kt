package com.agesadev.telmed.core

import com.agesadev.telmed.domain.model.Patient

interface ItemClick {
    fun onPatientClick(patient: Patient)
}