package com.example.composeyourlugguage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class LuggageViewmodel : ViewModel() {
    private val mapItemQuantity = MutableStateFlow(emptyMap<PersonalItem, Int>())

    val personalItems = mapItemQuantity.map { mapItemQuantity ->
        LuggageData.allItems.map { item ->
            PersonalItemInLuggage(item, mapItemQuantity[item] ?: 0)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
}

data class PersonalItemInLuggage(val item: PersonalItem, val quantity: Int)
