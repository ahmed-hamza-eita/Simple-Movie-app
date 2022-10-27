package com.hamza.hilt_navigation.data_model.local;

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {

    @TypeConverter
    fun fromString(value: String): List<Int> {
        val listType: Type = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(value, listType)
    }


    @TypeConverter
    fun fromArrayToJson(list: List<Int>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}