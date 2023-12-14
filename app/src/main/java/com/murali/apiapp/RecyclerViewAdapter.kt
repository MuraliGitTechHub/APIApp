package com.murali.apiapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.murali.apiapp.databinding.RecyclerviewListRowBinding
import com.murali.apiapp.model.RecyclerData
import java.util.Date

class RecyclerViewAdapter  : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){

    private var listData = mutableListOf<RecyclerData>()

    fun setUpdatedData(listDate : List<RecyclerData>){
          this.listData.addAll(listDate)
    }
     class MyViewHolder(binding : RecyclerviewListRowBinding) : RecyclerView.ViewHolder(binding.root){
         private val imageview = binding.imageView
         private val textviewName = binding.textviewName
         private val textviewDescription = binding.textviewDescription

               fun bind(data : RecyclerData){
                   textviewName.text = data.name
                   textviewDescription.text = data.description

                   Glide.with(imageview)
                       .load(data.owner.avatar_url)
                       .apply(RequestOptions.centerCropTransform())
                       .into(imageview)
               }
     }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//             val view =  LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_list_row,parent,false)
              return MyViewHolder(
                  RecyclerviewListRowBinding.inflate(
                      LayoutInflater.from(
                          parent.context
                      )
                  )
              )
    }
    override fun getItemCount(): Int {
        return listData.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         holder.bind(listData[position])
    }
}























//class RecyclerViewAdapter  : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){
//
//    private var listData : List<RecyclerData>? = null
//
//    fun setUpdatedData(listDate : List<RecyclerData>){
//          this.listData
//    }
//
//
//     class MyViewHolder(val binding : RecyclerviewListRowBinding) : RecyclerView.ViewHolder(binding.root){
//         val imageview = binding.imageView
//         val textviewName = binding.textviewName
//         val textviewDescription = binding.textviewDescription
//
//               fun bind(data : RecyclerData){
//                   textviewName.text = data.name
//                   textviewDescription.text = data.description
//
//                   Glide.with(imageview)
//                       .load(data.owner.avatar_url)
//                       .apply(RequestOptions.centerCropTransform())
//                       .into(imageview)
//
//               }
//     }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//             val view =  LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_list_row,parent,false)
//                 return MyViewHolder(
//                     RecyclerviewListRowBinding.inflate(
//                         LayoutInflater.from(
//                             parent.context
//                         )
//                     )
//                 )
//    }
//    override fun getItemCount(): Int {
//         if(listData == null)return  0
//             else return listData?.size!!
//    }
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//         holder.bind(listData?.get(position)!!)
//
//    }
//}