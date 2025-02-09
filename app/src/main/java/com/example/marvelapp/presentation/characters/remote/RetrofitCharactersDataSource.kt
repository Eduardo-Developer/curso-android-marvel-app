package com.example.marvelapp.presentation.characters.remote

import com.edudev.core.data.repository.CharactersRemoteDataSource
import com.example.marvelapp.framework.network.MarvelApi
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import javax.inject.Inject

class RetrofitCharactersDataSource @Inject constructor(
    private val marvelApi: MarvelApi) : CharactersRemoteDataSource<DataWrapperResponse>{

    override suspend fun fetchCharacters(queries: Map<String, String>): DataWrapperResponse {
        return marvelApi.getCharacters(queries)
    }
}