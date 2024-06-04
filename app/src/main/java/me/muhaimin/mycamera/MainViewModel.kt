package me.muhaimin.mycamera

import androidx.lifecycle.ViewModel
import me.muhaimin.mycamera.data.UploadRepository
import java.io.File

class MainViewModel(private val repository: UploadRepository) : ViewModel() {
    fun uploadImage(file: File, description: String) = repository.uploadImage(file, description)
}