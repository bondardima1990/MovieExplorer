package com.swat_cat.data.mappers

import com.swat_cat.data.dto.MovieDetailsDTO
import com.swat_cat.domain.Mapper
import com.swat_cat.domain.models.MovieDetails
import com.swat_cat.domain.models.transformRaitingToDouble

class MovieDetailsMapper:Mapper<MovieDetails,MovieDetailsDTO>{
    override fun fromDto(from: MovieDetailsDTO?): MovieDetails? {
        return MovieDetails(
            from?.title,
            from?.poster,
            from?.imdbID,
            from?.year,
            from?.genre?.split(','),
            transformRaitingToDouble(from?.ratings?.get(0)?.value)
        )
    }

    override fun toDto(to: MovieDetails?): MovieDetailsDTO? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}