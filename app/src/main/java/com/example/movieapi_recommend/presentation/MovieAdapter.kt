package com.example.movieapi_recommend.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapi_recommend.R
import com.example.movieapi_recommend.data.model.MovieItem
import com.example.movieapi_recommend.databinding.MovieItemBinding


class MovieAdapter:RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    private val movieList=ArrayList<MovieItem>()

    fun setList(movies:List<MovieItem>){
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : MovieItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.movie_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    class MyViewHolder(private val binding: MovieItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(movie:MovieItem){
            binding.movieTitle.text = movie.title
            binding.movieDesc.text = movie.overview

            val posterURL ="https://image.tmdb.org/t/p/w500/"+movie.posterPath

            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)
        }
    }

}