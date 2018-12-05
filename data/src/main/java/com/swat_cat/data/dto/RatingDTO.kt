package com.swat_cat.data.dto

import com.google.gson.annotations.SerializedName



class RatingDTO(
    @SerializedName("Value")
    val value: String? = null,

    @SerializedName("Source")
    val source: String? = null
)