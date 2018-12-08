package com.example.dima.screens.movie_list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dima.movieexplorer.R
import com.squareup.picasso.Picasso
import com.swat_cat.domain.models.Movie
import kotlinx.android.synthetic.main.movie_item.view.*
import java.util.zip.Inflater
import javax.security.auth.callback.Callback

class MovieAdapter(val movies:List<Movie>,val callback: (movie:Movie)-> Unit): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.movie_item,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        val movie = movies[p1]
        Picasso.get().load(movie.poster).into(holder.poster)
        holder.title.text = movie.title
        holder.year.text = movie.year?.toString()
        holder.itemView.setOnClickListener { callback(movie) }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val poster = itemView.poster
        val title = itemView.title
        val year = itemView.year
    }
}