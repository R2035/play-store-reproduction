package com.example.play.store.reproduction.item

sealed class SearchItemId {
    val id = this::class.java.typeName.hashCode().toLong()

    object Game : SearchItemId()
}
