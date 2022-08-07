package com.agesadev.telmed.domain.repository

import com.agesadev.telmed.core.Resource
import com.agesadev.telmed.domain.model.Patient
import kotlinx.coroutines.flow.Flow

interface PatientsRepository {
    fun getAllPatients(): Flow<Resource<List<Patient>>>
}