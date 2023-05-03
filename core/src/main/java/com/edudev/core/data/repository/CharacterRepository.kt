package com.edudev.core.data.repository

import androidx.paging.PagingSource

interface CharacterRepository {

    fun getCharacters(query: String): PagingSource<Int, com.edudev.core.domain.model.Character>
}