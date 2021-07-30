package com.itgonca.greatmovies.features.detail.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.itgonca.greatmovies.R
import com.itgonca.greatmovies.databinding.ItemCastLayoutBinding
import com.itgonca.greatmovies.domain.model.CastDto
import com.itgonca.greatmovies.utils.Constants.IMAGE_BASE_URL
import com.itgonca.greatmovies.utils.SizeImages.W154
import com.itgonca.greatmovies.utils.loadImage

class CastAdapter : ListAdapter<CastDto, CastAdapter.CastHolder>(CastDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastHolder {
        val view = ItemCastLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CastHolder(view)
    }

    override fun onBindViewHolder(holder: CastHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class CastHolder(private val binding: ItemCastLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemCast: CastDto) {
            with(itemCast) {
                binding.ivImagePerson.loadImage(
                    "$IMAGE_BASE_URL$W154$image",
                    imageError = R.drawable.ic_avatar_light
                )
                binding.tvCharacter.text = character
                binding.tvNamePerson.text = name
            }
        }
    }
}

class CastDiffUtilCallback() : DiffUtil.ItemCallback<CastDto>() {
    override fun areItemsTheSame(oldItem: CastDto, newItem: CastDto): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CastDto, newItem: CastDto): Boolean =
        oldItem == newItem
}