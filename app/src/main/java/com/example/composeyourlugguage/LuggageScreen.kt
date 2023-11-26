package com.example.composeyourlugguage

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// comp+invio per creare Composable Fun
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LuggageScreen(vm: LuggageViewmodel) {
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text(text = "Compose Your Luggage") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
    ) { innerPadding ->
        LazyColumn(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            items(vm.personalItems) {
                PersonalItem(it)
            }
        }
    }
}

@Composable
private fun PersonalItem(item: PersonalItem) {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = item.emoji,
            modifier = Modifier
                .padding(4.dp)
                .border(
                    width = 2.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(2.dp),
            style = MaterialTheme.typography.displayLarge
        )
        Column(Modifier.padding(horizontal = 8.dp)) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "${item.weight.format()} kg",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}