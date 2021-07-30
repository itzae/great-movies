package com.itgonca.greatmovies.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.itgonca.greatmovies.R
import com.itgonca.greatmovies.databinding.DialogLoaderBinding

class LoaderDialogFragment : DialogFragment() {
    private var _binding: DialogLoaderBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(): LoaderDialogFragment = LoaderDialogFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
        isCancelable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogLoaderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}