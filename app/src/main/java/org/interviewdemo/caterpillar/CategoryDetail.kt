package org.interviewdemo.caterpillar

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_category_detail.*
import org.interviewdemo.caterpillar.API.REST
import org.interviewdemo.caterpillar.Adapter.ResultDetailAdapter
import org.interviewdemo.caterpillar.Adapter.ResultImageAdapter
import org.interviewdemo.caterpillar.Data.Repository
import org.interviewdemo.caterpillar.Utilities.PARAM_DETAIL_DISPLAY

class CategoryDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_detail)

        initActivity()

    }
    //Init Activity
    private fun initActivity() {
        val isConnected= REST.isOnline(getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)

        if(!isConnected)
        {
            Toast.makeText(this,"No Network Connection", Toast.LENGTH_SHORT).show()
            return
        }
        txtResultDisplay.text = intent.getStringExtra(PARAM_DETAIL_DISPLAY)

        val resultAdapter = ResultDetailAdapter(this)
        val resultFeaturedImage = ResultImageAdapter(this)
        val repo = Repository()
        val listResultData = repo.getDetails()
        if (listResultData != null) {
            resultAdapter.resultDetails = listResultData.results
            resultFeaturedImage.images = listResultData.featuredPhotos

            lstCatDetailResults.adapter = resultAdapter
            lstCatDetailResultsImage.adapter = resultFeaturedImage

        }
    }
}
