package org.interviewdemo.caterpillar.API

import org.interviewdemo.caterpillar.Data.Category
import org.interviewdemo.caterpillar.Data.ItemDetail
import org.interviewdemo.caterpillar.Data.SubCategory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path



interface YardServiceCall{


    @GET("catalog.json")
    fun getCategories(): Call<List<Category>>

    @GET("catalog/{id}.json")
    fun getSubCategories(@Path("id") id:Int):Call<List<SubCategory>>

    @GET("results.json")
    fun getResult():Call<ItemDetail>

}

