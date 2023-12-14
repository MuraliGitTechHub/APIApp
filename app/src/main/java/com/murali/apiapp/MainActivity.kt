package com.murali.apiapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.murali.apiapp.databinding.ActivityMainBinding
import com.murali.apiapp.model.RecyclerList

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initViewModel()

    }
    private fun initRecyclerView() {
           binding.recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewAdapter()
        binding.recyclerview.adapter = recyclerViewAdapter
    }
    private fun initViewModel(){
         mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
         mainActivityViewModel.getLiveDataObserver().observe(this,object : Observer<RecyclerList?>{

             @SuppressLint("NotifyDataSetChanged")
             override fun onChanged(value: RecyclerList?) {
                          if( value != null){
                            recyclerViewAdapter.setUpdatedData(value.items)
                            recyclerViewAdapter.notifyDataSetChanged()
                          }else{
                              Toast.makeText(this@MainActivity,"Error is getting the data",Toast.LENGTH_LONG).show()
                          }
             }
         })
        mainActivityViewModel.makeApicall()
    }
}