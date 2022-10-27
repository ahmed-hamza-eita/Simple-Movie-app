package com.hamza.hilt_navigation.ui.home

import androidx.lifecycle.MutableLiveData
import com.hamza.hilt_navigation.data_model.DetailsModel
import com.hamza.hilt_navigation.data_model.local.MyDao
import com.hamza.hilt_navigation.network.ApiCalls
import javax.inject.Inject

class Repository @Inject constructor(val apiCalls: ApiCalls, val myDao: MyDao) {

    var error = MutableLiveData<String>()

    suspend fun getMovieRemote(): List<com.hamza.hilt_navigation.data_model.Result> {
        try {
            val data = apiCalls.getMovie()
            myDao.insertMovies(data.results)
            return data.results
        } catch (e: Exception) {
            error.postValue(e.localizedMessage)
            return myDao.getMovie()
        }
    }

    suspend fun getDetails(id: String): List<DetailsModel> {
        try {
            val data = apiCalls.getDetails(id)
            return listOf(data)
        } catch (e: Exception) {
            error.postValue(e.localizedMessage)
            return emptyList()
        }

    }
}


/*
    var movieLoveData = MutableLiveData<List<com.hamza.hilt_navigation.data_model.Result>>()
    var error = MutableLiveData<String>()

    suspend fun getMovieRemote() {
        try {
            val data = apiCalls.getMovie()
            movieLoveData.postValue(data.results)
            myDao.insertMovies(data.results)
        } catch (e: Exception) {
            getMovieLocal()
            error.postValue(e.localizedMessage)
        }
    }

    suspend fun getMovieLocal() {
        try {
            val data = myDao.getMovie()
            movieLoveData.postValue(data)
        } catch (e: Exception) {
            error.postValue(e.localizedMessage)
        }
    }

 */
