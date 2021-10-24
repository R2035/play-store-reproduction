package com.example.play.store.reproduction.screen.d01

import com.example.play.store.reproduction.base.BaseFragmentViewModel
import com.example.play.store.reproduction.item.SearchItem
import com.example.play.store.reproduction.item.SearchItemId
import com.example.play.store.reproduction.item.TabLayoutItem
import com.example.play.store.reproduction.item.TabLayoutItemId
import com.xwray.groupie.Section
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class BookFragmentViewModel : BaseFragmentViewModel() {
    val sections: Flow<List<Section>>

    private val _sections = MutableStateFlow(
        listOf(
            Section().apply {
                addAll(
                    listOf(
                        SearchItem(
                            id = SearchItemId.Game,
                            searchText = "書籍を検索",
                            userIconURL = "",
                            onSearchViewClick = {},
                            onVoiceImageViewClick = {},
                            onUserTextViewClick = {},
                        ),
                        TabLayoutItem(
                            id = TabLayoutItemId.Game,
                            tabNames = listOf(
                                "マンガ",
                                "電子書籍",
                                "オーディオブック",
                                "ジャンル",
                                "売上トップ",
                                "新作",
                                "無料トップ",
                            )
                        ),
                    )
                )
            }
        )
    )

    init {
        sections = _sections
    }
}
