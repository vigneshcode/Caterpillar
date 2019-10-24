package org.interviewdemo.caterpillar.Data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.interviewdemo.caterpillar.API.REST
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {


    fun getDetails():ItemDetail?{
        var detail:Call<ItemDetail> = REST.createObject().getResult()
        var responseDetail:ItemDetail?=null
        runBlocking(Dispatchers.IO) {
            launch {

               var response= detail.execute()
                if(response.isSuccessful)
                {
                    responseDetail=response.body()
                }


            }
        }

        return responseDetail

    }


    fun getSubCategories(pCategoryId:Int):List<SubCategory>{

        //Call the REST API
        var subCategory:Call<List<SubCategory>> = REST.createObject().getSubCategories(pCategoryId)
        var responseSubCategories:List<SubCategory>?=null

        runBlocking(Dispatchers.IO){

            launch{
                var response= subCategory.execute()
                if(response.isSuccessful){
                    responseSubCategories=response.body()
                }
                else{
                    responseSubCategories=listOf(SubCategory(0,"null","null"))

                }
            }

        }
        return responseSubCategories!!




    }

    //Get Categories
    fun getCategories():List<Category>{
        var returnCategory:List<Category>?=null
        var categories: Call<List<Category>> = REST.createObject().getCategories()

              runBlocking(Dispatchers.IO){

                  launch{

                     val response= categories.execute()
                      if(response.isSuccessful){
                          returnCategory=response.body()
                      }
                      else
                      {
                          returnCategory=listOf(Category(0,"Error Getting Response"))
                      }

                  }
              }


/*
        categories.enqueue(object: Callback<List<Category>> {
            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                Log.e("REST Call Error:",t.message)
                returnCategory=listOf(Category(0,"null"))
            }

            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            )
            {
                returnCategory= response.body()
                Log.i("REST Response","Recieved Categories")
            }
        })
*/
        return returnCategory!!
    }
}