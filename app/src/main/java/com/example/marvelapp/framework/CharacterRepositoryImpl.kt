package com.example.marvelapp.framework

import androidx.paging.PagingSource
import com.edudev.core.data.repository.CharacterRepository
import com.edudev.core.data.repository.CharactersRemoteDataSource
import com.edudev.core.domain.model.Character
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import com.example.marvelapp.framework.paging.CharactersPagingSource
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val remoteDataSource: CharactersRemoteDataSource<DataWrapperResponse>
) : CharacterRepository {
    override fun getCharacters(query: String): PagingSource<Int, Character> {
        return CharactersPagingSource(remoteDataSource, query)
    }
}