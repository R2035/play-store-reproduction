package com.example.play.store.reproduction.item

import android.view.View
import com.example.play.store.reproduction.R
import com.example.play.store.reproduction.base.BaseItem
import com.example.play.store.reproduction.databinding.ItemTabLayoutBinding
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.GroupieViewHolder

data class TabLayoutItem(
    private val id: TabLayoutItemId,
    val tabNames: List<String>
) : BaseItem<ItemTabLayoutBinding, TabLayoutItemPayload>(
    id.hashCode().toLong(),
) {
    override fun getPayload(): TabLayoutItemPayload {
        return TabLayoutItemPayload(
            tabNames,
        )
    }

    override fun getChange(newItem: Item<*>): TabLayoutItemPayload? {
        if (newItem !is TabLayoutItem) {
            return null
        }
        return newItem.getPayload()
    }

    override fun update(viewBinding: ItemTabLayoutBinding, payload: TabLayoutItemPayload) {
        viewBinding.itemTabTabLayout.removeAllTabs()
        payload.tabNames.forEach { tabName ->
            val tab = viewBinding.itemTabTabLayout.newTab()
            tab.text = tabName
            viewBinding.itemTabTabLayout.addTab(tab)
        }
    }

    override fun getLayout(): Int {
        return R.layout.item_tab_layout
    }

    override fun initializeViewBinding(view: View): ItemTabLayoutBinding {
        return ItemTabLayoutBinding.bind(view)
    }

    override fun unbind(viewHolder: GroupieViewHolder<ItemTabLayoutBinding>) {
        super.unbind(viewHolder)
    }
}
