package org.interviewdemo.caterpillar.Data

import com.google.gson.annotations.SerializedName

data class SubCategory (
    var id:Int,
    var detail:String,
    @SerializedName("display_name")
    var displayName:String

)