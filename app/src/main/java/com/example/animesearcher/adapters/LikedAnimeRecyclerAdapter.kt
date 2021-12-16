package com.example.animesearcher.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animesearcher.R
import com.example.animesearcher.databinding.ShortLikedAnimeLayoutBinding
import com.example.animesearcher.data.models.db.LikedAnime
import com.example.animesearcher.data.models.dtos.ShortAnimeModel

class LikedAnimeRecyclerAdapter(private val animals: List<ShortAnimeModel>) :
    RecyclerView.Adapter<LikedAnimeRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ShortLikedAnimeLayoutBinding.bind(itemView);
        fun bind(anima: ShortAnimeModel) {
            binding.animeTitle.text = anima.attributes.titles.English;
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.short_liked_anime_layout, parent, false);
        return MyViewHolder(view);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var anima = animals[position];
        holder.bind(anima);
    }

    override fun getItemCount(): Int {
        return animals.size;
    }


}