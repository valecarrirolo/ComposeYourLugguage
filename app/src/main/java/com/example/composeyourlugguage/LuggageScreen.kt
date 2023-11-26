package com.example.composeyourlugguage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// comp+invio per creare Composable Fun
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
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
        val personalItems by vm.personalItems.collectAsState()
        LazyColumn(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            item {
                Text(
                    text = "La valigia perfetta, senza stress!",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            stickyHeader {
                Card(
                    modifier = Modifier.padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.inversePrimary)
                ) {
                    val numItem = vm.numPersonalItems.collectAsState().value
                    val totalWeight = vm.totalWeight.collectAsState().value

                    Text(
                        text = "Stai portando $numItem oggetti con un peso stimato di ${totalWeight.format()} kg.",
                        Modifier.padding(8.dp)
                    )
                }
            }
            items(personalItems) { (item, quantity) ->
                PersonalItem(
                    item = item,
                    quantity = quantity,
                    onQuantityChange = { newQuantity ->
                        vm.onQuantityChange(item, newQuantity)
                    }
                )
            }
        }
    }
}

@Composable
private fun PersonalItem(item: PersonalItem, quantity: Int, onQuantityChange: (Int) -> Unit) {
    val inLuggage = quantity > 0
    Row(
        modifier = Modifier
            .clickable { onQuantityChange(quantity + 1) }
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = item.emoji,
            modifier = Modifier
                .padding(4.dp)
                .border(
                    width = 2.dp,
                    color = if (inLuggage) Color.Green else Color.LightGray,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(2.dp),
            style = MaterialTheme.typography.displayLarge
        )
        Column(
            Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = if (quantity > 1) {
                    val totalWeight = quantity * item.weight
                    "${totalWeight.format()} kg ($quantity x ${item.weight.format()} kg)"
                } else {
                    "${item.weight.format()} kg"
                },
                style = MaterialTheme.typography.bodyLarge
            )
        }
        if (inLuggage) {
            Text(text = quantity.toString())
            IconButton(onClick = { onQuantityChange(quantity - 1) }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "delete")
            }
        }
    }
}