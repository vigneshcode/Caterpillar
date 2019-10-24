package org.interviewdemo.caterpillar.API

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import org.interviewdemo.caterpillar.Utilities.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class REST {

    companion object{
        fun createObject():YardServiceCall{

            //Retrofit

            var builder=Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            var service=builder.create(YardServiceCall::class.java)

            return service


        }

        fun isOnline(conMgr: ConnectivityManager):Boolean{

            val networkInfo : NetworkInfo?= conMgr.activeNetworkInfo

            return networkInfo?.isConnected==true
        }

    }
}