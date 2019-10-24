/*
Adapter Class for Categories



 */


package org.interviewdemo.caterpillar.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.interviewdemo.caterpillar.Data.Category
import org.interviewdemo.caterpillar.R


//Category Adapter class used in showing list of categories.
class CategoryAdapter(val context: Context ):BaseAdapter() {

    var categories= listOf<Category>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {

        val itemView:ViewHolder
        var itemCategory:View

        //Optimize not to find inner views every time.
        if(view==null){
            itemCategory= LayoutInflater.from(context).inflate(R.layout.item_list_category,viewGroup,false)

            itemView=ViewHolder(itemCategory)
            itemCategory.tag=itemView



        }
        else
        {
            itemView=view.tag as ViewHolder
            itemCategory=view

        }

        //Set Values to inner view
        var currentItem=categories[position]
       // itemView.categoryIcon.setImageResource()
        itemView.categoryName.text=currentItem.name


            return itemCategory


    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return categories[position].id.toLong()
    }

    override fun getCount(): Int {
        return categories.size
    }

    //View holder class hold reference to item view, which can referenced while binding
    private class ViewHolder(view:View){
        var categoryName:TextView=view.findViewById(R.id.itemListTextView)

    }
}