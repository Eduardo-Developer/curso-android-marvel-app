package com.example.marvelapp.presentation.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.edudev.core.domain.model.Character
import com.edudev.core.usecase.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    fun charactersPagingData(query: String): Flow<PagingData<Character>> {
        return getCharacterUseCase(
            GetCharacterUseCase.GetCharactersParams(query, getPageConfig())
        ).cachedIn(viewModelScope)
    }

    private fun getPageConfig() = PagingConfig(
        pageSize = 20
    )
}