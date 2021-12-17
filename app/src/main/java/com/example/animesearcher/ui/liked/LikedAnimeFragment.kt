package com.example.animesearcher.ui.liked

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animesearcher.R
import com.example.animesearcher.adapters.LikedAnimeRecyclerAdapter
import com.example.animesearcher.data.database.DbRepos
import com.example.animesearcher.databinding.LikedAnimeFragmentBinding
import com.example.animesearcher.other.AnimeSearcherApp
import com.example.animesearcher.ui.list.ListFragmentDirections
import com.example.animesearcher.ui.list.ListViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LikedAnimeFragment : Fragment() {

    companion object {
        fun newInstance() = LikedAnimeFragment()
    }

    private lateinit var viewModel: LikedAnimeViewModel
    private lateinit var listViewModel: ListViewModel
    private lateinit var binding: LikedAnimeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(requireActivity()).get(LikedAnimeViewModel::class.java)
        listViewModel = ViewModelProvider(requireActivity()).get(ListViewModel::class.java)
        binding = LikedAnimeFragmentBinding.inflate(inflater, container, false);

        binding.likedAnimeRecycler.layoutManager = LinearLayoutManager(requireContext());

        listViewModel.Db.likedAnimals.observe(viewLifecycleOwner) {
            binding.likedAnimeRecycler.adapter =
                LikedAnimeRecyclerAdapter(it, this@LikedAnimeFragment::goToAnime);
        }
        lifecycleScope.launch {
            listViewModel.Db.getAll();
        }

        return binding.root;
    }

    private fun goToAnime(AnimeId: Int) {
        val activity = requireActivity();
        val host =
            activity.supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment;
        val action = LikedAnimeFragmentDirections.actionLikedAnimeFragmentToSingleAnime();
        action.animeId = AnimeId;
        host.findNavController().navigate(action);
    }

}