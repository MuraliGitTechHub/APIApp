package com.murali.apiapp.di

import com.murali.apiapp.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {

    fun inject(mainActivityViewModel : MainActivityViewModel)
}