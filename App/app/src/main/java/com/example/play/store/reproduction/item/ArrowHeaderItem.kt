package com.example.play.store.reproduction.item

import android.view.View
import androidx.core.view.isGone
import com.example.play.store.reproduction.R
import com.example.play.store.reproduction.base.BaseItem
import com.example.play.store.reproduction.databinding.ItemArrowHeaderBinding
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.GroupieViewHolder

data class ArrowHeaderItem(
    private val id: String,
    val title: String,
    val subtitle: String,
    val onClick: () -> Unit,
) : BaseItem<ItemArrowHeaderBinding, ArrowHeaderItemPayload>(
    id.hashCode().toLong(),
) {
    override fun getPayload(): ArrowHeaderItemPayload {
        return ArrowHeaderItemPayload(
            title,
            subtitle,
            onClick,
        )
    }

    override fun getChange(newItem: Item<*>): ArrowHeaderItemPayload? {
        if (newItem !is ArrowHeaderItem) {
            return null
        }
        return newItem.getPayload()
    }

    override fun update(viewBinding: ItemArrowHeaderBinding, payload: ArrowHeaderItemPayload) {
        viewBinding.itemArrowHeaderTitleTextView.text = payload.title
        viewBinding.itemArrowHeaderSubtitleTextView.text = payload.subtitle
        viewBinding.itemArrowHeaderSubtitleTextView.isGone = payload.subtitle.isEmpty()
        viewBinding.root.setOnClickListener { payload.onClick() }
    }

    override fun getLayout(): Int {
        return R.layout.item_arrow_header
    }

    override fun initializeViewBinding(view: View): ItemArrowHeaderBinding {
        return ItemArrowHeaderBinding.bind(view)
    }

    override fun unbind(viewHolder: GroupieViewHolder<ItemArrowHeaderBinding>) {
        viewHolder.binding.root.setOnClickListener(null)
        super.unbind(viewHolder)
    }
}
