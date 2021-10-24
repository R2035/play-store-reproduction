package com.example.play.store.reproduction.item

data class SearchItemPayload(
    val userName: String,
    val onSearchViewClick: () -> Unit,
    val onVoiceImageViewClick: () -> Unit,
    val onUserTextViewClick: () -> Unit,
)
