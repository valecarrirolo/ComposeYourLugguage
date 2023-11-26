package com.example.composeyourlugguage

data class PersonalItem(
    val emoji: String,
    val name: String,
    val weight: Float,
)

// https://bit.ly/compose-your-luggage
object LuggageData {
    val allItems = listOf(
        PersonalItem("👕", "T-shirt", weight = 0.3f),
        PersonalItem("👔", "Camicia", weight = 0.3f),
        PersonalItem("👖", "Pantalone/Gonna", weight = 0.3f),
        PersonalItem("👗", "Vestito", weight = 0.5f),
        PersonalItem("👖", "Jeans", weight = 0.5f),
        PersonalItem("🧥", "Giacca", weight = 1f),
        PersonalItem("🧣", "Maglione", weight = 0.2f),
        PersonalItem("🧢", "Cappello", weight = 0.05f),
        PersonalItem("🧣", "Sciarpa", weight = 0.3f),
        PersonalItem("🧤", "Guanti", weight = 0.1f),
        PersonalItem("🧦", "Calze", weight = 0.1f),
        PersonalItem("👔", "Cravatta", weight = 0.15f),
        PersonalItem("🩳", "Costume", weight = 0.3f),
        PersonalItem("🛂", "Passaporto", weight = 0.1f),
        PersonalItem("🆔", "Carta d'identità", weight = 0.3f),
        PersonalItem("✈️", "Biglietto aereo", weight = 0.1f),
        PersonalItem("🛳", "Biglietto del traghetto", weight = 0.1f),
        PersonalItem("🧳", "Assicurazione di viaggio", weight = 0.1f),
        PersonalItem("🏨", "Prenotazione albergo", weight = 0.1f),
        PersonalItem("🚗", "Prenotazione auto", weight = 0.1f),
        PersonalItem("👛", "Portafoglio", weight = 0.1f),
        PersonalItem("📱", "Cellulare", weight = 0.3f),
        PersonalItem("📷", "Macchina fotografica", weight = 0.5f),
        PersonalItem("⌚️", "Orologio", weight = 0.1f),
        PersonalItem("🕶", "Occhiali da sole", weight = 0.1f),
        PersonalItem("🎧", "Auricolari", weight = 0.1f),
        PersonalItem("📚", "Libro", weight = 0.3f),
        PersonalItem("🥜", "Snack", weight = 0.3f),
        PersonalItem("🍷", "Bevande", weight = 0.3f),
        PersonalItem("💊", "Medicine", weight = 0.3f),
    )
}
