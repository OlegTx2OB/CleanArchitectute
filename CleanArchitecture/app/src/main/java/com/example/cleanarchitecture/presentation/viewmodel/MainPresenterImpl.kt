package com.example.cleanarchitecture.presentation.viewmodel

import android.util.Log
import com.example.cleanarchitecture.domain.model.User
import com.example.cleanarchitecture.domain.usecase.GetUserUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserUseCase
import com.example.cleanarchitecture.presentation.presenter.MainPresenter
import com.example.cleanarchitecture.presentation.presenter.MainView
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainPresenterImpl @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase,
    private val view: MainView
) : MainPresenter {

    init {
        Log.e("AAA", "VM created")
    }

    override fun save(text: String){
        val param = User(text)
        val result = saveUserUseCase.execute(param)
        view.showResult("Save result = $result")
    }

    override fun load(){
        view.showResult(getUserUseCase.execute().firstName)
    }
}