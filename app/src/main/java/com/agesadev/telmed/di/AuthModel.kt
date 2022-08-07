package com.agesadev.telmed.di

import com.agesadev.telmed.BuildConfig
import com.agesadev.telmed.core.Utils
import com.agesadev.telmed.data.remote.dto.RemoteApi
import com.agesadev.telmed.data.repository.LoginRepositoryImpl
import com.agesadev.telmed.data.repository.PatientRepositoryImpl
import com.agesadev.telmed.domain.repository.LoginRepository
import com.agesadev.telmed.domain.repository.PatientsRepository
import com.agesadev.telmed.domain.usecases.GetPatientsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AuthModel {


    @Provides
    @Singleton
    fun provideOkHttpClient() =
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
        } else {
            OkHttpClient.Builder().build()
        }

    @Provides
    @Singleton
    fun provideAuthApi(): RemoteApi {
        return Retrofit.Builder()
            .baseUrl(Utils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
            .create(RemoteApi::class.java)
    }


    @Provides
    @Singleton
    fun provideLoginRepository(remoteApi: RemoteApi): LoginRepository {
        return LoginRepositoryImpl(remoteApi)
    }


    @Provides
    @Singleton
    fun providePatientsRepository(remoteApi: RemoteApi): PatientsRepository {
        return PatientRepositoryImpl(remoteApi)
    }

    @Provides
    @Singleton
    fun providePatientsUseCase(patientsRepository: PatientsRepository) =
        GetPatientsUseCase(patientsRepository)


}