package com.hamza.hilt_navigation.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamza.hilt_navigation.data_model.DetailsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repo: Repository) : ViewModel() {

    var error: MutableLiveData<String> = repo.error
    val movieLiveData = MutableLiveData<List<com.hamza.hilt_navigation.data_model.Result>?>()
    val detailsLiveData = MutableLiveData<List<DetailsModel>?>()

    fun getters() {
        viewModelScope.launch {
            val data = repo.getMovieRemote()
            movieLiveData.postValue(data)
        }
    }

    fun getDetails(id: String) {
        viewModelScope.launch {
            val data = repo.getDetails(id)
            detailsLiveData.postValue(data)

        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}
