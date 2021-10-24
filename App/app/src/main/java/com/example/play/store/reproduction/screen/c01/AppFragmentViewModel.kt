package com.example.play.store.reproduction.screen.c01

import com.example.play.store.reproduction.base.BaseFragmentViewModel
import com.example.play.store.reproduction.item.SearchItem
import com.example.play.store.reproduction.item.SearchItemId
import com.example.play.store.reproduction.item.TabLayoutItem
import com.example.play.store.reproduction.item.TabLayoutItemId
import com.xwray.groupie.Section
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class AppFragmentViewModel : BaseFragmentViewModel() {
    val sections: Flow<List<Section>>

    private val _sections = MutableStateFlow(
        listOf(
            Section().apply {
                addAll(
                    listOf(
                        SearchItem(
                            id = SearchItemId.Game,
                            searchText = "アプリやゲームを検索する",
                            userIconURL = "",
                            onSearchViewClick = {},
                            onVoiceImageViewClick = {},
                            onUserTextViewClick = {},
                        ),
                        TabLayoutItem(
                            id = TabLayoutItemId.Game,
                            tabNames = listOf(
                                "おすすめ",
                                "ランキング",
                                "子供",
                                "カテゴリ",
                                "エディターのおすすめ",
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
