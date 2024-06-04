package me.muhaimin.mycamera.data.di

import me.muhaimin.mycamera.data.UploadRepository
import me.muhaimin.mycamera.data.api.ApiConfig

object Injection {
    fun provideRepository(): UploadRepository {
        val apiService = ApiConfig.getApiService()
        return UploadRepository.getInstance(apiService)
    }
}