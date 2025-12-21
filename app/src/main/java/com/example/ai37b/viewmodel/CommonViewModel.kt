package com.example.ai37b.viewmodel

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.ai37b.repository.CommonRepo

class CommonViewModel(val repo: CommonRepo) : ViewModel() {

    fun uploadImage(
        context: Context,
        imageUri: Uri, callback: (String?) -> Unit
    ) {
        repo.uploadImage(context, imageUri, callback)
    }
}