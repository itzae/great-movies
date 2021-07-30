package com.itgonca.greatmovies.features.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.itgonca.greatmovies.databinding.ItemRowMoviesLayoutBinding
import com.itgonca.greatmovies.domain.model.CategoryDto
import com.itgonca.greatmovies.domain.model.MoviePosterDto

class MoviesCategoriesAdapter(private val onItemClick: (MoviePosterDto) -> Unit) :
    ListAdapter<CategoryDto, MoviesCategoriesAdapter.CategoryViewHolder>(CategoryDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view =
            ItemRowMoviesLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class CategoryViewHolder(private val binding: ItemRowMoviesLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemCategory: CategoryDto) {
            val moviesAdapter = MoviesAdapter { onItemClick(it) }
            moviesAdapter.submitList(itemCategory.listMovie)
            binding.tvCategory.text = itemCategory.name
            binding.rvMovies.adapter = moviesAdapter
        }
    }

}

class CategoryDiffUtilCallback() : DiffUtil.ItemCallback<CategoryDto>() {
    override fun areItemsTheSame(oldItem: CategoryDto, newItem: CategoryDto): Boolean =
        oldItem.idCategory == newItem.idCategory

    override fun areContentsTheSame(oldItem: CategoryDto, newItem: CategoryDto): Boolean =
        oldItem == newItem
}