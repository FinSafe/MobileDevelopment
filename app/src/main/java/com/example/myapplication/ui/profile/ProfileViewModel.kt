package com.example.myapplication.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repository.FinsafeRepository
import kotlinx.coroutines.launch

class ProfileViewModel (private val repository: FinsafeRepository): ViewModel(){
    private lateinit var setting: SettingPreferences
    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }

    fun getThemeSettings() : LiveData<Boolean> {
        return setting.getThemeSetting().asLiveData()
    }

    fun settingPreferences(settingPreferences: SettingPreferences) {
        this.setting = settingPreferences
    }

    fun saveThemeSetting(isDarkModeActive: Boolean) {
        viewModelScope.launch {
            setting.saveThemeSetting(isDarkModeActive)
        }
    }
}