package com.example.cleanarchitecture.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.model.User
import com.example.cleanarchitecture.domain.usecase.GetUserUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : ViewModel() {

    private val _sfText = MutableStateFlow<String>("No data")
    val sfText: StateFlow<String> = _sfText

    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun save(text: String){
        val param = User(text)
        val result = saveUserUseCase.execute(param)
        _sfText.value = "Save result = $result"
    }

    fun load(){
        _sfText.value = getUserUseCase.execute().firstName
    }
}