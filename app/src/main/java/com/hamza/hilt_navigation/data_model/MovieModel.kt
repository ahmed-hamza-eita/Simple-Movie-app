package com.hamza.hilt_navigation.data_model;

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.hamza.hilt_navigation.data_model.local.Converters

data class MovieModel(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)

@Entity
data class Result(
    val adult: Boolean,
    val backdrop_path: String,
    @TypeConverters(Converters::class)
    val genre_ids: List<Int>,
    @PrimaryKey
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)