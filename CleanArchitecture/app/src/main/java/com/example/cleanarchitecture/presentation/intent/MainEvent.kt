package com.example.cleanarchitecture.presentation.intent

sealed class MainEvent {
    class SaveEvent(val text: String) : MainEvent()
    class LoadEvent : MainEvent()
}