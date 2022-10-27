package com.hamza.hilt_navigation.data_model.local;

 import androidx.room.*


@Database(entities = arrayOf(com.hamza.hilt_navigation.data_model.Result::class), version = 1)
@TypeConverters(Converters::class)
abstract class MyDataBase : RoomDatabase() {
    abstract fun getDao(): MyDao




}