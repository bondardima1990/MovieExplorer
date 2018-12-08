package com.swat_cat.data.mappers

import com.swat_cat.data.dto.MovieDTO
import com.swat_cat.domain.Mapper
import com.swat_cat.domain.models.Movie

class MovieMapper:Mapper<Movie?,MovieDTO?>{
    override fun fromDto(from: MovieDTO?): Movie {
        return Movie(
            from?.title,
            from?.poster,
            from?.imdbID,
            from?.year)
    }

    override fun toDto(to: Movie?): MovieDTO? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
