package com.swat_cat.data.dto
import com.google.gson.annotations.SerializedName


class MovieDTO (
    @SerializedName("Type")
     var type: String? = null,

    @SerializedName("Year")
     var year: Int? = null,

    @SerializedName("imdbID")
     var imdbID: String? = null,

    @SerializedName("Poster")
     var poster: String? = null,

    @SerializedName("Title")
     var title: String? = null
)