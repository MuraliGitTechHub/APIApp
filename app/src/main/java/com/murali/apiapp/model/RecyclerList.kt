package com.murali.apiapp.model


data class RecyclerList(val items : List<RecyclerData>)
data class RecyclerData(val name : String,val description : String,val owner :Owner1)
data class Owner1(val avatar_url : String)
