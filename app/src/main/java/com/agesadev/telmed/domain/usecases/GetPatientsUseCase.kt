package com.agesadev.telmed.domain.usecases

import com.agesadev.telmed.domain.repository.PatientsRepository
import javax.inject.Inject

class GetPatientsUseCase @Inject constructor(
    private val patientsRepository: PatientsRepository
) {
    operator fun invoke() = patientsRepository.getAllPatients()

}