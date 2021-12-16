package com.example.animesearcher.data.net

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

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