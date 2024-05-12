package me.muhaimin.loginwithanimation.di

import android.content.Context
import me.muhaimin.loginwithanimation.data.UserRepository
import me.muhaimin.loginwithanimation.data.pref.UserPreference
import me.muhaimin.loginwithanimation.data.pref.dataStore

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(pref)
    }
}