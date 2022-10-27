package com.hamza.hilt_navigation.di;

import android.content.Context
import androidx.room.Room
import com.hamza.hilt_navigation.Const
import com.hamza.hilt_navigation.data_model.local.MyDao
import com.hamza.hilt_navigation.data_model.local.MyDataBase
import com.hamza.hilt_navigation.network.ApiCalls
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    //retrofit
    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit
    }

    @Singleton
    @Provides
    fun getApiCalls(retrofit: Retrofit): ApiCalls {
        return retrofit.create(ApiCalls::class.java)

    }


    //Room
    @Singleton
    @Provides
    fun getRoomDatabase(@ApplicationContext context: Context): MyDataBase {
        val myDataBase = Room.databaseBuilder(context, MyDataBase::class.java, Const.DB_NAME)
            .fallbackToDestructiveMigration().build()
        return myDataBase
    }

    @Singleton
    @Provides
    fun getDao(myDataBase: MyDataBase): MyDao {
        return myDataBase.getDao()
    }
}