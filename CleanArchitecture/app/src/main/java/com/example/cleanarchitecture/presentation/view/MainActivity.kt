package com.example.cleanarchitecture.presentation.view

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.presentation.presenter.MainView
import com.example.cleanarchitecture.presentation.viewmodel.MainPresenterImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    val dataTextView by lazy {findViewById<TextView>(R.id.dataTextView)}
    val dataEditView by lazy {findViewById<EditText>(R.id.dataEditText)}
    val sendButton by lazy {findViewById<Button>(R.id.sendButton)}
    val receiveButton by lazy {findViewById<Button>(R.id.receiveButton)}

    private val mVm: MainPresenterImpl by viewModels()
    override fun showResult(text: String) {
        dataTextView.text = text
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created")



        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            mVm.save(text)
        }

        receiveButton.setOnClickListener {
            mVm.load()
        }
    }
}