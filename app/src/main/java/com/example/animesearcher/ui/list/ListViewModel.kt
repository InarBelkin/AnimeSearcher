package com.example.animesearcher.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animesearcher.data.database.DbRepos
import com.example.animesearcher.data.database.IDbRepos
import com.example.animesearcher.data.database.LikedAnimeDao
import com.example.animesearcher.data.models.dtos.ShortAnimeModel
import com.example.animesearcher.data.net.ISearchRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListViewModel @Inject constructor(
    private val Search: ISearchRepository,
    val Db: IDbRepos
) : ViewModel() {
    private val animalsLiveData = MutableLiveData(ArrayList<ShortAnimeModel>());

    var searchString = "";
    val animals
        get() = animalsLiveData;

    fun updateAnime() {
        Search.getAllAnime(this::searchCall)
    }

    fun searchAnime() {
        if (searchString.isNotEmpty()) Search.getAnimeByName(
            searchString,
            this::searchCall
        ) else updateAnime()
    }

    fun searchCall(animals: ArrayList<ShortAnimeModel>) {
        viewModelScope.launch {
            animals.forEach { anime ->
                anime.isLiked = Db.getByAnimeId(anime.id).isNotEmpty();
            }
            animalsLiveData.value = animals;
        }
    }

//    @Inject
//    protected lateinit var testRepos: ITestRepos;
}