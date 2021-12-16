package com.example.animesearcher.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animesearcher.models.dtos.ShortAnimeModel
import com.example.animesearcher.repository.ISearchRepository

import com.example.animesearcher.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ListViewModel @Inject constructor(private val Search: ISearchRepository) : ViewModel() {
    private val animalsLiveData = MutableLiveData(ArrayList<ShortAnimeModel>());

    public val animals
        get() = animalsLiveData;

    public fun updateAnime() {
        Search.getAllAnime {
            animalsLiveData.value = it;
        }
    }

    public fun searchAnime(searchString: String) {
        Search.getAnimeByName(searchString) {
            animalsLiveData.value = it;
        }


    }

//    @Inject
//    protected lateinit var testRepos: ITestRepos;
}