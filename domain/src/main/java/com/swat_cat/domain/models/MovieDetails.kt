package com.swat_cat.domain.models

class MovieDetails(
    val title:String? = null,
    val poster:String? = null,
    val imdbId:String? = null,
    val year:Int,
    val ganres:List<String?>? = null,
    val raiting:Double?
)