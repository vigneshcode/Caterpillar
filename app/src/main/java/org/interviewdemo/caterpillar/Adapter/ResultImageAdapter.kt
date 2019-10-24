package org.interviewdemo.caterpillar.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import org.interviewdemo.caterpillar.Data.FeaturedPhoto
import org.interviewdemo.caterpillar.R

//Result Image Adapter is used in showing list of Images
class ResultImageAdapter(private val context:Context):BaseAdapter() {

    var images=listOf<FeaturedPhoto>()


    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {

        val imageHolder:ImageHolder
        val imageView:View
        //Get the View
        if(view==null)
        {
            imageView=LayoutInflater.from(context).inflate(R.layout.item_results_image,parent,false)
            imageHolder=ImageHolder(imageView)
            imageView.tag=imageHolder
        }
        else
        {
            imageHolder=view.tag as ImageHolder
            imageView=view
        }

        //Bind Data
        imageHolder.bind(images[position])

        return imageView
    }

    override fun getItem(p0: Int)=images[p0]



    override fun getItemId(p0: Int)=p0.toLong()

    override fun getCount()=images.size



    //Class that hold the reference to item views
    class ImageHolder(val view:View){

        var image:ImageView?=null

        init {
            image =view.findViewById(R.id.imgResultFeatured)
        }

        fun bind(image:FeaturedPhoto){

            Glide.with(view)
                .load(image.url)
                .override(200,200)
                .fitCenter()
                .into(this.image!!)

            //Image.=image.url
        }

    }

}