package com.example.animesearcher.data.database

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
public class DbModule {

        @Provides
        fun getDao(app:Application): LikedAnimeDao{
            return Room.databaseBuilder(app.applicationContext, AppDatabase::class.java, "database")
                .fallbackToDestructiveMigration()
                .build().likedAnimeDao();
        }
}

//@Module
//@InstallIn(Fragment::class)
//public class ReposDbModule(){
//
//    @Provides
//    fun getDao(app:Application): LikedAnimeDao{
//        return Room.databaseBuilder(app.applicationContext, AppDatabase::class.java, "database")
//            .fallbackToDestructiveMigration()
//            .build().likedAnimeDao();
//    }
//}