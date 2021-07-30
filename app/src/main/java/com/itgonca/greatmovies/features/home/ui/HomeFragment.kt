package com.itgonca.greatmovies.features.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.itgonca.greatmovies.MainActivity
import com.itgonca.greatmovies.R
import com.itgonca.greatmovies.databinding.FragmentHomeBinding
import com.itgonca.greatmovies.domain.model.CategoryDto
import com.itgonca.greatmovies.features.home.ui.adapter.MoviesCategoriesAdapter
import com.itgonca.greatmovies.features.home.viewmodel.HomeViewModel
import com.itgonca.greatmovies.utils.Constants.ID_MOVIE
import com.itgonca.greatmovies.utils.StateUi
import com.itgonca.greatmovies.utils.asActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var categoryAdapter: MoviesCategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryAdapter =
            MoviesCategoriesAdapter {
                findNavController().navigate(
                    R.id.action_homeFragment_to_movieDetail,
                    bundleOf(ID_MOVIE to it.idMovie)
                )
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initObservers()
    }


    private fun initUI() {
        binding.rvCategories.run {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initObservers() {
        homeViewModel.listMovies.observe(viewLifecycleOwner, ::showMovies)
    }

    private fun showMovies(movies: StateUi<List<CategoryDto>>) {
        when (movies) {
            StateUi.Loading -> {
                asActivity<MainActivity>().showLoader(true)
            }
            is StateUi.Success -> {
                asActivity<MainActivity>().showLoader(false)
                categoryAdapter.submitList(movies.data)
                binding.rvCategories.adapter = categoryAdapter
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