package com.example.cleanarchitecture.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.model.User
import com.example.cleanarchitecture.domain.usecase.GetUserUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserUseCase
import com.example.cleanarchitecture.presentation.intent.MainEvent
import com.example.cleanarchitecture.presentation.intent.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : ViewModel() {

    private val _sfState = MutableStateFlow<MainState>(MainState(false, ""))
    val sfState: StateFlow<MainState> = _sfState

    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun send(event: MainEvent) {
        when (event) {

            is MainEvent.SaveEvent -> {
                save(event.text)
            }
            is MainEvent.LoadEvent -> {
                load()
            }
        }
    }

    private fun save(text: String) {
        val param = User(text)
        val result = saveUserUseCase.execute(param)
        _sfState.value = MainState(
            saveResult = result,
            firstName = _sfState.value.firstName
        )
    }

    private fun load() {
        val user = getUserUseCase.execute()
        _sfState.value = MainState(
            saveResult = _sfState.value.saveResult,
            firstName =user.firstName
        )
    }
}