package com.example.animesearcher.ui.list

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.animesearcher.data.database.IDbRepos
import com.example.animesearcher.data.models.db.LikedAnime
import com.example.animesearcher.data.models.dtos.ShortAnimeModel
import com.example.animesearcher.data.net.ISearchRepository

import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class ListViewModelTest : TestCase() {
    @Test
    fun searchCall() = runBlocking {
        val a = Mockito.mock(ISearchRepository::class.java);
        val db = Mockito.mock(IDbRepos::class.java);
        val viewModel = ListViewModel(a, db);


        Mockito.`when`(db.getByAnimeId(10)).thenReturn(ArrayList<LikedAnime>())
        Mockito.`when`(db.getByAnimeId(20))
            .thenReturn(listOf(LikedAnime(2, 20, "bebeb")))

        val animals = ArrayList<ShortAnimeModel>();
        animals.add(ShortAnimeModel());
        animals.add(ShortAnimeModel());
        animals[0].id = 10;
        animals[1].id = 20;

        val job = viewModel.searchCall(animals);
        while (!job.isCompleted);

        Assert.assertEquals(false, animals[0].isLiked);
        Assert.assertEquals(true, animals[1].isLiked);
    }
}