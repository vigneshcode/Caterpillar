package org.interviewdemo.caterpillar.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler_category.view.*
import org.interviewdemo.caterpillar.Data.SubCategory
import org.interviewdemo.caterpillar.R


//SubCategory Adapter class is used in Subcategory Recycler View
class SubCategoryAdapter(val clickListener: (SubCategory) -> Unit):RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder>() {


    private var listSubCategories=listOf<SubCategory>()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {

        val layout=LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_category,parent,false)
        return SubCategoryViewHolder(layout)
    }

    override fun getItemCount()=listSubCategories.size


    override fun getItemId(position: Int)=listSubCategories[position].id.toLong()


    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {

       holder.bind(listSubCategories[position],clickListener)

    }



    //View holder class hold reference to item view, which can referenced while binding
     class SubCategoryViewHolder(view: View):RecyclerView.ViewHolder(view){

        fun bind(subCategory:SubCategory,clicklist:(SubCategory)->Unit){
            itemView.txtSubCategoryDisplayName.text=subCategory.displayName
            itemView.txtSubCategoryDetail.text=subCategory.detail
            itemView.setOnClickListener { clicklist(subCategory) }

        }



    }


    //set the Adapter data
    fun setData(pList:List<SubCategory>){

        this.listSubCategories=pList
        notifyDataSetChanged()
    }
}