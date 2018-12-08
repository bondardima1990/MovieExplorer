package com.swat_cat.domain.models

import java.util.*

class MovieDetails(
    val title:String? = null,
    val poster:String? = null,
    val imdbId:String? = null,
    val year:String?,
    val ganres:List<String?>? = null,
    val raiting:Double?
)

fun transformRaitingToDouble(rawRaiting: String?):Double{
    var raiting = 0.0
    /*if (rawRaiting != null && rawRaiting.matches("\\d+".toRegex())) {
        raiting = java.lang.Double.valueOf(rawRaiting)
    } else if (rawRaiting != null && !rawRaiting.isEmpty()) {
        if (rawRaiting.contains("%")) {
            val percent = rawRaiting.replace("%", "")
            val p = Integer.valueOf(percent)
            raiting = p / 100.0
        } else if (rawRaiting.contains("/")) {
            val values = rawRaiting.split("/".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
            val intVal = List()
            for (v in values) {
                v = v.trim({ it <= ' ' })
                intVal.add(java.lang.Double.valueOf(v))
            }
            if (intVal.size == 2) {
                raiting = intVal.get(0) / intVal.get(1)
            }
        }
    }*/
    return raiting
}