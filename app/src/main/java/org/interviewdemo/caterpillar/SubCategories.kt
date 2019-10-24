package org.interviewdemo.caterpillar

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sub_categories.*
import org.interviewdemo.caterpillar.API.REST
import org.interviewdemo.caterpillar.Adapter.SubCategoryAdapter
import org.interviewdemo.caterpillar.Data.Repository
import org.interviewdemo.caterpillar.Data.SubCategory
import org.interviewdemo.caterpillar.Utilities.*

class SubCategories : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_categories)


        initAcitivity()


    }

    private fun initAcitivity() {

        val isConnected= REST.isOnline(getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)

        if(!isConnected)
        {
            Toast.makeText(this,"No Network Connection",Toast.LENGTH_SHORT).show()
            return
        }

        val subCategoryAdapter =
            SubCategoryAdapter { subCategory: SubCategory -> subCategoryClick(subCategory) }
        val subCategoryRepo = Repository()
        val categoryId = intent.getIntExtra(PARAM_SUBCATEGORY, 0)
        if (categoryId > 0) {
            subCategoryAdapter.setData(subCategoryRepo.getSubCategories(categoryId))

        }


        recyclerSubCategories.adapter = subCategoryAdapter
    }

    //SubCategory Click Handler
    private fun subCategoryClick(subCategory:SubCategory){

        val detailIntent= Intent(this,CategoryDetail::class.java)

        detailIntent.putExtra(PARAM_DETAIL_DISPLAY,subCategory.displayName)
        startActivity(detailIntent)


    }
}
