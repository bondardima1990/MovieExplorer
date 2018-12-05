package com.swat_cat.domain

interface Mapper<M,D>{
    fun fromDto(from:D?):M?
    fun toDto(to:M?):D?
}