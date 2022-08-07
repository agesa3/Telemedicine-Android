package com.agesadev.telmed.data.repository

import com.agesadev.telmed.core.Resource
import com.agesadev.telmed.data.remote.dto.RemoteApi
import com.agesadev.telmed.data.remote.dto.patient.toPatient
import com.agesadev.telmed.domain.model.Patient
import com.agesadev.telmed.domain.repository.PatientsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class PatientRepositoryImpl @Inject constructor(
    private val remoteApi: RemoteApi
) : PatientsRepository {
    override fun getAllPatients(): Flow<Resource<List<Patient>>> = flow {
        try {
            emit(Resource.Loading())
            val patients = remoteApi.getPatients().data.map {
                it.toPatient()
            }
            emit(Resource.Success(patients))
        } catch (e: Exception) {
//            emit(Resource.Error(e.localizedMessage ?: "An error occured"))
        } catch (e: Exception) {
//            emit(Resource.Error(e.localizedMessage ?: "Opps!! Failed.PLease Retry"))
        }

    }

}
