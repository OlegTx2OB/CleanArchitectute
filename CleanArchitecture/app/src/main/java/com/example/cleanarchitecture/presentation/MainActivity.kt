package com.example.cleanarchitecture.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.sharedPrefs.SharedPrefUserStorageImpl
import com.example.cleanarchitecture.domain.model.User
import com.example.cleanarchitecture.domain.usecase.GetUserUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserUseCase
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mVM by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created")

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        lifecycleScope.launch { //launchWhenStarted
            mVM.sfText.collect {
                dataTextView.text = it
            }
        }

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            mVM.save(text)
        }

        receiveButton.setOnClickListener {
            mVM.load()
        }
    }
}