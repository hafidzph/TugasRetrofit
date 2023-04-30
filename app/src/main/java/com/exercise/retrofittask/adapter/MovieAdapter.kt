package com.exercise.retrofittask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exercise.retrofittask.model.Result
import com.exercise.retrofittask.databinding.ItemMovieBinding


class MovieAdapter(var listFilm: List<Result>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(detailFilm: Result){
            val imgUrl = "https://image.tmdb.org/t/p/w500/${detailFilm.posterPath}"
            binding.movieTitle.text = detailFilm.title
            Glide.with(itemView).load(imgUrl).into(binding.movieImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listFilm[position])
}