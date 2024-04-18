package com.example.cleanarchitecture.presentation.view

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.app.App
import com.example.cleanarchitecture.presentation.viewmodel.MainViewModel
import com.example.cleanarchitecture.presentation.viewmodelfactory.MainViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mVmFactory: MainViewModelFactory
    private lateinit var mVm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)

        Log.e("AAA", "Activity created")

        mVm = ViewModelProvider(this, mVmFactory).get(MainViewModel::class.java)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        lifecycleScope.launch { //launchWhenStarted
            mVm.sfText.collect {
                dataTextView.text = it
            }
        }

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            mVm.save(text)
        }

        receiveButton.setOnClickListener {
            mVm.load()
        }
    }
}