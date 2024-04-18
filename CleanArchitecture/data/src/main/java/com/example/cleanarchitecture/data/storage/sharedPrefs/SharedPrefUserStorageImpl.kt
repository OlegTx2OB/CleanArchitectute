package com.example.cleanarchitecture.data.storage.sharedPrefs

import android.content.Context
import com.example.cleanarchitecture.data.dto.UserDto
import com.example.cleanarchitecture.data.storage.UserStorage

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "first_name"
private const val DEFAULT_FIRST_NAME = "Default first name"

class SharedPrefUserStorageImpl(context: Context) : UserStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(userDto: UserDto): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, userDto.firstName).apply()

        return true
    }

    override fun get(): UserDto {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME)
            ?: DEFAULT_FIRST_NAME

        return UserDto(firstName = firstName)
    }
}