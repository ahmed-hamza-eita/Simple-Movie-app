package com.hamza.hilt_navigation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hamza.hilt_navigation.Const
import com.hamza.hilt_navigation.databinding.ItemViewMoviesBinding
import java.util.concurrent.TimeUnit

class MoviesAdapter(val click: (movieId:Int) -> Unit) : RecyclerView.Adapter<MoviesAdapter.Holder>() {


    var listMovie: ArrayList<com.hamza.hilt_navigation.data_model.Result>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemViewMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = listMovie?.get(position)!!
        holder.binding.apply {
            movieName.text = data.title
            Glide.with(holder.itemView.context).load("${Const.BASE_URL_IMAGES}${data.poster_path}")
                .into(imgMovie)
        }
    }

    override fun getItemCount(): Int {
        return listMovie?.size ?: 0
    }


    inner class Holder(val binding: ItemViewMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                click.invoke(listMovie?.get(layoutPosition)?.id!!)
            }
        }
    }

}