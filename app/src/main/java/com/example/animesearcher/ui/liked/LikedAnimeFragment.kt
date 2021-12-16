package com.example.animesearcher.ui.liked

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animesearcher.R
import com.example.animesearcher.adapters.LikedAnimeRecyclerAdapter
import com.example.animesearcher.databinding.LikedAnimeFragmentBinding
import com.example.animesearcher.other.AnimeSearcherApp

class LikedAnimeFragment : Fragment() {

    companion object {
        fun newInstance() = LikedAnimeFragment()
    }

    private lateinit var viewModel: LikedAnimeViewModel
    private lateinit var binding: LikedAnimeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(LikedAnimeViewModel::class.java)
        binding = LikedAnimeFragmentBinding.inflate(inflater, container, false);

        binding.likedAnimeRecycler.layoutManager = LinearLayoutManager(requireContext());

        val dao = AnimeSearcherApp.instance.database.likedAnimeDao()
        val allAnime = dao.getAll();
        allAnime.observe(viewLifecycleOwner) {
            val t = ArrayList(it);
            binding.likedAnimeRecycler.adapter = LikedAnimeRecyclerAdapter(t);
        }
        return binding.root;
    }
}