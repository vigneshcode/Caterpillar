package org.interviewdemo.caterpillar

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.interviewdemo.caterpillar.API.REST
import org.interviewdemo.caterpillar.Adapter.CategoryAdapter
import org.interviewdemo.caterpillar.Data.Category
import org.interviewdemo.caterpillar.Data.Repository
import org.interviewdemo.caterpillar.Utilities.PARAM_SUBCATEGORY

class Categories : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        initActivity()

    }

    private fun initActivity() {
        val categoryRep = Repository()
        val category = CategoryAdapter(this)

      val isConnected= REST.isOnline(getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)

        if(!isConnected)
        {
            Toast.makeText(this,"No Network Connection",Toast.LENGTH_SHORT).show()
            return
        }
        category.categories = categoryRep.getCategories()
        lstCategories.adapter = category


        // Event Handler for List
        lstCategories.setOnItemClickListener { adapterView, view, pos, id ->


            //call intent
            var subcategoryIntent = Intent(this, SubCategories::class.java).apply {
                //putExtras(subcategoryBundle)
                putExtra(PARAM_SUBCATEGORY, id.toInt())

            }

            startActivity(subcategoryIntent)


        }
    }
}
