package com.example.play.store.reproduction.item

data class ArrowHeaderItemPayload(
    val title: String,
    val subtitle: String,
    val onClick: () -> Unit,
)
