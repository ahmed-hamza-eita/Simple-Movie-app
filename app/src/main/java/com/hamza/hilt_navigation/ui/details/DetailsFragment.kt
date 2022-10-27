package com.hamza.hilt_navigation.ui.details;

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.hamza.hilt_navigation.Const
import com.hamza.hilt_navigation.R
import com.hamza.hilt_navigation.databinding.FragmentDetailsBinding
import com.hamza.hilt_navigation.databinding.FragmentHomeBinding
import com.hamza.hilt_navigation.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : Fragment() {
    var _bindind: FragmentDetailsBinding? = null
    val binding get() = _bindind
    val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bindind = FragmentDetailsBinding.bind(view)
        val id=DetailsFragmentArgs.fromBundle(requireArguments()).movieId
        homeViewModel.getDetails(id)
        observers()
    }

    private fun observers() {
        homeViewModel.detailsLiveData.observe(viewLifecycleOwner) {
            binding?.apply {
              txtName.text = it?.get(0)?.original_title.toString()
                txtDescription.text = it?.get(0)?.overview
                Glide.with(requireActivity())
                    .load("${Const.BASE_URL_IMAGES}${it?.get(0)?.poster_path}")
                    .into(binding!!.imgMovie)
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _bindind = null
    }
}