package com.murali.apiapp.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetroModule {
    val baseURL = "https://api.github.com/search/"     // End Point : repositories?q=newyork

    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit: Retrofit) : RetrofitServiceInterface{
        return retrofit.create(RetrofitServiceInterface::class.java)
    }
    @Singleton
    @Provides
    fun getRetrofitInstance() : Retrofit{
          return Retrofit.Builder()
              .baseUrl(baseURL)
              .addConverterFactory(GsonConverterFactory.create())
              .build()
    }
}