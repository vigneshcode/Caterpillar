package org.interviewdemo.caterpillar.Data

import com.google.gson.annotations.SerializedName

data class ItemDetail (
    @SerializedName("display_name")
    var displayName:String,
    var results:List<Result>,
    @SerializedName("featured_photos")
    var featuredPhotos:List<FeaturedPhoto>
)