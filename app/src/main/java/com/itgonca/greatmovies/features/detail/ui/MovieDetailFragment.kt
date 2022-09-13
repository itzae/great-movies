package com.itgonca.greatmovies.features.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.itgonca.greatmovies.MainActivity
import com.itgonca.greatmovies.databinding.FragmentMovieDetailBinding
import com.itgonca.greatmovies.domain.model.DetailDto
import com.itgonca.greatmovies.features.detail.ui.adapter.CastAdapter
import com.itgonca.greatmovies.features.detail.ui.adapter.GenresMovieAdapter
import com.itgonca.greatmovies.features.detail.viewmodel.DetailViewModel
import com.itgonca.greatmovies.utils.Constants.ID_MOVIE
import com.itgonca.greatmovies.utils.Constants.IMAGE_BASE_URL
import com.itgonca.greatmovies.utils.SizeImages.W780
import com.itgonca.greatmovies.utils.StateUi
import com.itgonca.greatmovies.utils.asActivity
import com.itgonca.greatmovies.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailViewModel by viewModels()
    private lateinit var genresAdapter: GenresMovieAdapter
    private lateinit var castAdapter: CastAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapters()
        initUi()
        initObservers()
        viewModel.fetchMovieDetail(arguments?.getInt(ID_MOVIE) ?: 0)
    }

    private fun initUi() {
        asActivity<MainActivity>().apply {
            setSupportActionBar(binding.toolbarDetail)
            setupActionBarWithNavController(
                findNavController(),
                AppBarConfiguration(findNavController().graph)
            )
        }

    }

    private fun initObservers() {
        viewModel.detailMovieInfo.observe(viewLifecycleOwner, ::setData)
    }

    private fun initAdapters() {
        genresAdapter = GenresMovieAdapter()
        castAdapter = CastAdapter()
    }

    private fun setData(dataDetail: StateUi<DetailDto>) {
        when (dataDetail) {
            StateUi.Loading -> asActivity<MainActivity>().showLoader(true)
            is StateUi.Success -> {
                asActivity<MainActivity>().showLoader(false)
                with(dataDetail.data) {
                    binding.ivBackdropMovie.loadImage("$IMAGE_BASE_URL$W780$backdropImage")
                    binding.collapsingToolbar.title = title
                    binding.contentDetail.tvContentOverview.text = overview
                    genresAdapter.submitList(genres)
                    binding.contentDetail.rvGenres.adapter = genresAdapter
                    castAdapter.submitList(castList)
                    binding.contentDetail.rvCast.adapter = castAdapter
                }
            }
            is StateUi.Error -> {
                asActivity<MainActivity>().showLoader(false)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}