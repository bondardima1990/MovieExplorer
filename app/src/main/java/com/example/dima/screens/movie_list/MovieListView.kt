package com.example.dima.screens.movie_list

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.jakewharton.rxbinding2.widget.RxTextView
import com.swat_cat.domain.models.Movie
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.view.*

class MovieListView(val root:View):MovieListContract.View{

    private var searchField:TextView = root.search
    private var searchResult:RecyclerView = root.result
    private var emptyMessage:TextView = root.empty
    private var progress:ProgressBar = root.progress

    override fun searchChanged(): Observable<CharSequence> {
        return RxTextView.textChanges(searchField)
    }

    override fun clean(clean: () -> Unit) {
        searchField.text =""
    }

    override fun setMovieList(movies: List<Movie>, itemClicked: (movie: Movie) -> Unit) {
       val  glm = GridLayoutManager(root.context,2,GridLayoutManager.VERTICAL,false)
       val  adapter = MovieAdapter(movies,itemClicked)
        searchResult.layoutManager = glm
        searchResult.adapter = adapter
    }

    override fun showProgress(boolean: Boolean) {
        if(boolean){
            searchResult.visibility = View.GONE
            progress.visibility = View.VISIBLE
        }else{
            searchResult.visibility = View.VISIBLE
            progress.visibility = View.GONE
        }
    }

    override fun showEmptY(boolean: Boolean) {
        if(boolean){
            emptyMessage.visibility = View.VISIBLE
            searchResult.visibility = View.GONE
        }else{
            emptyMessage.visibility = View.GONE
            searchResult.visibility = View.VISIBLE
        }
    }
}