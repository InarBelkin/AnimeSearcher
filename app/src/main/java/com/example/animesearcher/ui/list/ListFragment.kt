package com.example.animesearcher.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animesearcher.R
import com.example.animesearcher.adapters.AnimeListRecyclerAdapter
import com.example.animesearcher.databinding.ListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.animesearcher.models.db.LikedAnime
import com.example.animesearcher.other.AnimeSearcherApp
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel // by viewModels();
    private lateinit var binding: ListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(ListViewModel::class.java)
        binding = ListFragmentBinding.inflate(inflater, container, false);
        viewModel.updateAnime();
        binding.animeRecycler.layoutManager = LinearLayoutManager(requireContext());

        viewModel.animals.observe(viewLifecycleOwner) {

            binding.animeRecycler.adapter = AnimeListRecyclerAdapter(viewModel.animals.value!!) {animeId->GoToAnime(animeId)};
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                viewModel.searchAnime(p0 ?: "");
                return false;
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

        })

        return binding.root;
    }

    public fun GoToAnime(AnimeId: Int) {
        val activity = requireActivity();
        val host =
            activity.supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment;
        val action = ListFragmentDirections.actionListFragmentToSingleAnime();
        action.animeId = AnimeId;
        host.findNavController().navigate(action);
    }


}