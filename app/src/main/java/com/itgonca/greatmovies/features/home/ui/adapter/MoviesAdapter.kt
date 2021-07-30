package com.itgonca.greatmovies.features.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.itgonca.greatmovies.databinding.ItemMoviePosterLayoutBinding
import com.itgonca.greatmovies.domain.model.MoviePosterDto
import com.itgonca.greatmovies.utils.Constants.IMAGE_BASE_URL
import com.itgonca.greatmovies.utils.SizeImages.W154
import com.itgonca.greatmovies.utils.loadImage

class MoviesAdapter(private val onItemClick: (MoviePosterDto) -> Unit) :
    ListAdapter<MoviePosterDto, MoviesAdapter.MoviesViewHolder>(MoviesPosterDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            ItemMoviePosterLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class MoviesViewHolder(private val binding: ItemMoviePosterLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemMovie: MoviePosterDto) {
            binding.ivPosterMovie.loadImage("$IMAGE_BASE_URL$W154${itemMovie.pathImage}")
            itemView.setOnClickListener { onItemClick(itemMovie) }
        }
    }
}

class MoviesPosterDiffUtilCallback : DiffUtil.ItemCallback<MoviePosterDto>() {
    override fun areItemsTheSame(oldItem: MoviePosterDto, newItem: MoviePosterDto): Boolean =
        oldItem.idMovie == newItem.idMovie

    override fun areContentsTheSame(oldItem: MoviePosterDto, newItem: MoviePosterDto): Boolean =
        oldItem == newItem
}