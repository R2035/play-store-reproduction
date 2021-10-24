package com.example.play.store.reproduction.item

sealed class TabLayoutItemId {
    val id = this::class.java.name.hashCode().toLong()

    object Game : TabLayoutItemId()
}
