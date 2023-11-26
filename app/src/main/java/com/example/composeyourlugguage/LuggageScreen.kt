package com.example.composeyourlugguage

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// comp+invio per creare Composable Fun
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LuggageScreen(vm: LuggageViewmodel) {
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text(text = "Compose Your Luggage") },
            )
        },
    ) { innerPadding ->
        LazyColumn(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            items(vm.personalItems) {
                Text(text = "Item $it")
            }
        }
    }
}