package com.itgonca.greatmovies.features.detail.ui.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.itgonca.greatmovies.R
import com.itgonca.greatmovies.data.network.model.Genre
import com.itgonca.greatmovies.databinding.ItemGenreLayoutBinding
import com.itgonca.greatmovies.utils.getContrastColor
import com.itgonca.greatmovies.utils.randomColor

class GenresMovieAdapter :
    ListAdapter<Genre, GenresMovieAdapter.GenresMovieHolder>(GenreMovieDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresMovieHolder {
        val view =
            ItemGenreLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenresMovieHolder(view)
    }

    override fun onBindViewHolder(holder: GenresMovieHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class GenresMovieHolder(private val binding: ItemGenreLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemGenre: Genre) {

            binding.chGenre.apply {
                val colorSelected = ContextCompat.getColor(
                    itemView.context,
                    R.color.yellow_500
                )
                text = itemGenre.name
                chipBackgroundColor = ColorStateList.valueOf(colorSelected)
                setTextColor(getContrastColor(colorSelected))
            }

        }
    }
}

class GenreMovieDiffUtilCallback : DiffUtil.ItemCallback<Genre>() {
    override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean =
        oldItem.genreId == newItem.genreId

    override fun areContentsTheSame(oldItem: Genre, newItem: Genre): Boolean = oldItem == newItem
}