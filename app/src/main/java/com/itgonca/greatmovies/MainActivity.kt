package com.itgonca.greatmovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.itgonca.greatmovies.databinding.ActivityMainBinding
import com.itgonca.greatmovies.utils.LoaderDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class MainActivity : AppCompatActivity() {

    private var dialogLoader: LoaderDialogFragment? = null

    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()
    }

    private fun initComponents() {
        navController = Navigation.findNavController(this, R.id.navHostFragment)
        NavigationUI.setupWithNavController(binding.bottomNav, navController!!)
        dialogLoader = LoaderDialogFragment.newInstance()
    }

    open fun showLoader(isShow: Boolean) {
        if (isShow)
            dialogLoader?.show(supportFragmentManager, "Loader")
        else
            dialogLoader?.dismiss()
    }
}