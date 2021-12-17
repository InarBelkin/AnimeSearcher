package com.example.animesearcher.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animesearcher.data.database.DbRepos
import com.example.animesearcher.data.database.IDbRepos
import com.example.animesearcher.data.database.LikedAnimeDao
import com.example.animesearcher.data.models.dtos.ShortAnimeModel
import com.example.animesearcher.data.net.ISearchRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ListViewModel @Inject constructor(
    private val Search: ISearchRepository,
    val Db: IDbRepos
) : ViewModel() {
    private val animalsLiveData = MutableLiveData(ArrayList<ShortAnimeModel>());

    val animals
        get() = animalsLiveData;

    fun updateAnime() {
        Search.getAllAnime {
            animalsLiveData.value = it;
        }
    }

    fun searchAnime(searchString: String) {
        Search.getAnimeByName(searchString) {
            animalsLiveData.value = it;
        }


    }

//    @Inject
//    protected lateinit var testRepos: ITestRepos;
}