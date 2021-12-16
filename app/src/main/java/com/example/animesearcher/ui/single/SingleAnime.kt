package com.example.animesearcher.ui.single

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.animesearcher.databinding.SingleAnimeFragmentBinding
import com.example.animesearcher.data.models.dtos.ShortAnimeModel
import com.example.animesearcher.ui.list.ListViewModel
import com.squareup.picasso.Picasso

class SingleAnime : Fragment() {

    companion object {
        fun newInstance() = SingleAnime()
    }

    private lateinit var viewModel: SingleAnimeViewModel
    private lateinit var viewModelList: ListViewModel
    private lateinit var binding: SingleAnimeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(SingleAnimeViewModel::class.java)
        viewModelList = ViewModelProvider(requireActivity()).get(ListViewModel::class.java)
        binding = SingleAnimeFragmentBinding.inflate(inflater, container, false);

        val args: SingleAnimeArgs by navArgs();
        var anime: ShortAnimeModel? = null;
        viewModelList.animals.value!!.forEach {
            if (it.id == args.animeId)
                anime = it;
        }
        binding.anime = anime;
        binding.rating.text = "Rating:" + (anime?.attributes?.averageRating ?: "no data");
        val imgUrl = anime!!.attributes.posterImage.medium;
        val imageView = binding.titleImage;
        Picasso.get().load(imgUrl).into(imageView);

        return binding.root;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move);
    }


}