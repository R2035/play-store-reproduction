package com.example.play.store.reproduction.screen.b01

import com.example.play.store.reproduction.base.BaseFragmentViewModel
import com.example.play.store.reproduction.item.SearchItem
import com.example.play.store.reproduction.item.SearchItemId
import com.xwray.groupie.Section
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class GameFragmentViewModel : BaseFragmentViewModel() {
    val sections: Flow<List<Section>>

    private val _sections = MutableStateFlow(
        listOf(
            Section().apply {
                add(SearchItem(SearchItemId.Game, "A", {}, {}, {}))
            }
        )
    )

    init {
        sections = _sections
    }
}
