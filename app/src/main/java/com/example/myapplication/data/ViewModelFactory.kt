package com.example.myapplication.data

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.repository.FinsafeRepository
import com.example.myapplication.data.repository.Injection
import com.example.myapplication.ui.Login.LoginViewModel
import com.example.myapplication.ui.home.MainViewModel
import com.example.myapplication.ui.profile.ProfileViewModel
import com.example.myapplication.ui.register.RegisterViewModel

class ViewModelFactory private constructor(private val repository: FinsafeRepository): ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(repository) as T
            }
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> {
                return ProfileViewModel(repository) as T
            }
            modelClass.isAssignableFrom(MainViewModel::class.java) -> { // Add MainViewModel here
                MainViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("UnknownViewModel class: " + modelClass.name)
        }


    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory {
            if (INSTANCE ==null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(Injection.provideRepository(context))
                }
            }
            return INSTANCE as ViewModelFactory
        }

    }
}