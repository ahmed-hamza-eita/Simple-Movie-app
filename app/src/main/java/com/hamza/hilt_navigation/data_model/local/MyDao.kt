package com.hamza.hilt_navigation.data_model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
      suspend  fun insertMovies(list: List<com.hamza.hilt_navigation.data_model.Result>)

    @Query("SELECT * FROM RESULT")
     suspend  fun getMovie(): List<com.hamza.hilt_navigation.data_model.Result>
}