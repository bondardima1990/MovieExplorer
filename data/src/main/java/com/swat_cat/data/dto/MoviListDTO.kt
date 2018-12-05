package com.swat_cat.data.dto

import com.google.gson.annotations.SerializedName



class MoviListDTO(
    @SerializedName("Response")
     var response: String? = null,

    @SerializedName("totalResults")
     var totalResults: Long? = null,

    @SerializedName("Search")
     var search: List<MovieDTO>? = null
)