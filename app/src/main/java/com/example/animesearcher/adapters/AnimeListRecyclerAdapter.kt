package com.example.animesearcher.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.animesearcher.R
import com.example.animesearcher.data.database.IDbRepos
import com.example.animesearcher.databinding.ShortAnimeLayoutBinding
import com.example.animesearcher.data.models.db.LikedAnime
import com.example.animesearcher.data.models.dtos.ShortAnimeModel
import com.example.animesearcher.other.AnimeSearcherApp
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

class AnimeListRecyclerAdapter(
    private val shortAnime: ArrayList<ShortAnimeModel>,
    private val db: IDbRepos,
    private val goToAnimeCall: (Int) -> Unit
) :
    RecyclerView.Adapter<AnimeListRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        val binding = ShortAnimeLayoutBinding.bind(itemView);
        fun bind(anima: ShortAnimeModel, goToAnimeCall: (Int) -> Unit, db: IDbRepos) {
            binding.title.text = anima.attributes.titles.English;
            binding.dates.text = anima.attributes.startDate + " - " + anima.attributes.endDate;
            binding.rating.text = "Rating: " + anima.attributes.averageRating ?: "No data";
            val imgUrl = anima.attributes.posterImage.medium;
            val imageView = binding.imageView;
            Picasso.get().load(imgUrl).into(imageView)
            imageView.setOnClickListener {
                goToAnimeCall.invoke(anima.id);
            }
            binding.checkLike.isChecked = anima.isLiked;
            itemView.context
            binding.checkLike.setOnCheckedChangeListener { p0, b ->
                itemView.findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
                    if (b) db.AddLike(anima) else db.deleteByAnimeId(anima.id);
                    anima.isLiked = b;
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.short_anime_layout, parent, false);
        return MyViewHolder(view);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var anima = shortAnime[position];
        holder.bind(anima, goToAnimeCall, db);
    }

    override fun getItemCount(): Int {
        return shortAnime.size;
    }

    companion object {
        private const val TAG = "AnimeListRecyclerAdapter";
    }

}
