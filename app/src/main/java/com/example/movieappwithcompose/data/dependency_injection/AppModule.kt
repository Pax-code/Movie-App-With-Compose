package com.example.movieappwithcompose.data.dependency_injection

import com.example.movieappwithcompose.data.remote.MovieAPI
import com.example.movieappwithcompose.data.repository.MovieRepoImpl
import com.example.movieappwithcompose.domain.repository.MovieRepo
import com.example.movieappwithcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideMovieAPI(): MovieAPI{
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }


    @Provides
    @Singleton
    fun provideMovieRepo(api: MovieAPI): MovieRepo {
        return MovieRepoImpl(api = api)
    }

}