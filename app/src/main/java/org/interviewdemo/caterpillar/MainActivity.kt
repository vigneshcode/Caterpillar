package org.interviewdemo.caterpillar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.interviewdemo.caterpillar.API.REST
import org.interviewdemo.caterpillar.Data.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgYardClub.setOnClickListener {

        var intent= Intent(this,Categories::class.java)

            startActivity(intent)


        }
    }
}
