package com.example.play.store.reproduction.item

sealed class SearchItemId {
    val id = this::class.java.name.hashCode().toLong()

    object Game : SearchItemId()
}
