package com.hamza.hilt_navigation.ui.home;

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.hamza.hilt_navigation.R
import com.hamza.hilt_navigation.data_model.Result
import com.hamza.hilt_navigation.databinding.FragmentHomeBinding
import com.hamza.hilt_navigation.ui.adapters.MoviesAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {
    var _bindind: FragmentHomeBinding? = null
    val binding get() = _bindind
    lateinit var moviesAdapter: MoviesAdapter
    val homeViewModel: HomeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bindind = FragmentHomeBinding.bind(view)
        homeViewModel.getters()
        observes()
        action()
    }

    private fun observes() {
        homeViewModel.movieLiveData.observe(viewLifecycleOwner) {
            moviesAdapter.listMovie = it as ArrayList<com.hamza.hilt_navigation.data_model.Result>
            binding?.recycler?.adapter = moviesAdapter
        }
    }

    private fun action() {
        moviesAdapter = MoviesAdapter {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                    it.toString()
                )
            )
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _bindind = null
    }
}