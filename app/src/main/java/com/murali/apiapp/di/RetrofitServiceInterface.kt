package com.murali.apiapp.di

import com.murali.apiapp.model.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface RetrofitServiceInterface {

     @GET("repositories")
     fun getDataFromAPI(@Query("q")query: String):Call<RecyclerList>?

}