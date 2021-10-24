package com.example.play.store.reproduction.item

data class SpecialFeatureItemPayload(
    val thumbnailImageURL: String,
    val title: String,
    val description: String,
    val link: String,
    val onCardClick: () -> Unit,
    val onLinkClick: () -> Unit,
)
