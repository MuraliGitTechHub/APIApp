package com.murali.apiapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.murali.apiapp.di.RetrofitServiceInterface
import com.murali.apiapp.model.MyApplication
import com.murali.apiapp.model.RecyclerList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel(application : Application) : AndroidViewModel(application){
    @Inject lateinit var mService : RetrofitServiceInterface

    private  var liveDataList: MutableLiveData<RecyclerList?>
    init {
        (application as MyApplication).getRetroComponent().inject(this)
        liveDataList = MutableLiveData()

    }
    fun getLiveDataObserver(): MutableLiveData<RecyclerList?> {
           return liveDataList
    }
    fun makeApicall() {
        val call : Call<RecyclerList>? = mService.getDataFromAPI("atl")
        call?.enqueue(object  : Callback<RecyclerList>{
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                      if(response.isSuccessful){
                          liveDataList.postValue(response.body())
                      }else {
                          liveDataList.postValue(null)
                      }
            }
            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                    liveDataList.postValue(null)
            }
        })
    }
}