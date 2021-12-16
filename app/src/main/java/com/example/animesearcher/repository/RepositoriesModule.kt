package com.example.animesearcher.repository

import com.example.animesearcher.other.AnimeSearcherApp
import com.example.animesearcher.ui.list.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule {
//    @Provides
//    fun getSearchRepository(): ISearchRepository {
//        return SearchRepository();
//    }
            @Binds
        abstract fun getSearchRepository(repository: SearchRepository):ISearchRepository ;

}