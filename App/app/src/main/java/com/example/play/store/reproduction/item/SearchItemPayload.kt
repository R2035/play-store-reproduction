package com.example.play.store.reproduction.item

data class SearchItemPayload(
    val userIconURL: String,
    val searchText: String,
    val onSearchViewClick: () -> Unit,
    val onVoiceImageViewClick: () -> Unit,
    val onUserTextViewClick: () -> Unit,
)
