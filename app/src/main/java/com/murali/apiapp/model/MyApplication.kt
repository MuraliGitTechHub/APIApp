package com.murali.apiapp.model

import android.app.Application
import com.murali.apiapp.di.DaggerRetroComponent
import com.murali.apiapp.di.RetroComponent
import com.murali.apiapp.di.RetroModule

class MyApplication : Application() {

    private lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()
        retroComponent = DaggerRetroComponent.builder()
            .retroModule(RetroModule())
            .build()
    }
    fun getRetroComponent() : RetroComponent {
        return retroComponent
    }
}
