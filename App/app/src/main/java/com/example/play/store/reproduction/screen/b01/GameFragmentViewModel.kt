package com.example.play.store.reproduction.screen.b01

import com.example.play.store.reproduction.base.BaseFragmentViewModel
import com.example.play.store.reproduction.item.SearchItem
import com.example.play.store.reproduction.item.SearchItemId
import com.example.play.store.reproduction.item.SpecialFeatureItem
import com.example.play.store.reproduction.item.TabLayoutItem
import com.example.play.store.reproduction.item.TabLayoutItemId
import com.xwray.groupie.Section
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class GameFragmentViewModel : BaseFragmentViewModel() {
    val sections: Flow<List<Section>>

    private val _sections = MutableStateFlow(
        listOf(
            Section().apply {
                addAll(
                    listOf(
                        SearchItem(
                            id = SearchItemId.Game,
                            searchText = "アプリやゲームを検索する",
                            userIconURL = "A",
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
                        SpecialFeatureItem(
                            id = "SpecialFeatureItem0",
                            thumbnailImageURL = "",
                            title = "タイトルタイトルタイトルタイトルタイトルタイトルタイトルタイトルタイトルタイトルタイトルタイトルタイトルタイトルタイトルタイトルタイトル",
                            description = "説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明",
                            link = "詳細はこちら",
                            onCardClick = {},
                            onLinkClick = {},
                        ),
                        SpecialFeatureItem(
                            id = "SpecialFeatureItem1",
                            thumbnailImageURL = "",
                            title = "タイトルタイトルタイトルタイトルタイトルタイトル",
                            description = "説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明",
                            link = "詳細はこちら",
                            onCardClick = {},
                            onLinkClick = {},
                        ),
                        SpecialFeatureItem(
                            id = "SpecialFeatureItem2",
                            thumbnailImageURL = "",
                            title = "タイトルタイトルタイトルタイトルタイトルタイトルタイトルタイトルタイトルタイトルタイトル",
                            description = "説明説明説明説明説明説明説明説明説明説明説明説明",
                            link = "詳細はこちら",
                            onCardClick = {},
                            onLinkClick = {},
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
