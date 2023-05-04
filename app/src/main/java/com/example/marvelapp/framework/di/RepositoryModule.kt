package com.example.marvelapp.framework.di

import com.edudev.core.data.repository.CharacterRepository
import com.edudev.core.data.repository.CharactersRemoteDataSource
import com.example.marvelapp.framework.CharacterRepositoryImpl
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import com.example.marvelapp.presentation.characters.remote.RetrofitCharactersDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCharacterRepository(
        repository: CharacterRepositoryImpl
    ) : CharacterRepository

    @Binds
    fun bindRemoteDataSource(
        dataSource: RetrofitCharactersDataSource
    ) : CharactersRemoteDataSource<DataWrapperResponse>
}