package com.example.play.store.reproduction.view

import com.example.play.store.reproduction.item.TabLayoutItem
import com.jay.widget.StickyHeaders
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class StickyHeaderGroupAdapter : GroupAdapter<GroupieViewHolder>(), StickyHeaders {
    override fun isStickyHeader(position: Int): Boolean {
        return getItem(position) is TabLayoutItem
    }
}
