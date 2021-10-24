package com.example.play.store.reproduction.item

import android.graphics.drawable.ColorDrawable
import android.view.View
import com.example.play.store.reproduction.R
import com.example.play.store.reproduction.base.BaseItem
import com.example.play.store.reproduction.databinding.ItemSearchBinding
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.GroupieViewHolder

data class SearchItem(
    private val id: SearchItemId,
    val userIconURL: String,
    val onSearchViewClick: () -> Unit,
    val onVoiceImageViewClick: () -> Unit,
    val onUserTextViewClick: () -> Unit,
) : BaseItem<ItemSearchBinding, SearchItemPayload>(
    id.hashCode().toLong(),
) {
    override fun getPayload(): SearchItemPayload {
        return SearchItemPayload(
            userIconURL,
            onSearchViewClick,
            onVoiceImageViewClick,
            onUserTextViewClick,
        )
    }

    override fun getChange(newItem: Item<*>): SearchItemPayload? {
        if (newItem !is SearchItem) {
            return null
        }
        return newItem.getPayload()
    }

    override fun update(viewBinding: ItemSearchBinding, payload: SearchItemPayload) {
        viewBinding.itemSearchSearchIconImageView.setOnClickListener { payload.onSearchViewClick() }
        viewBinding.itemSearchSearchTextView.setOnClickListener { payload.onSearchViewClick() }
        viewBinding.itemSearchVoiceIconImageView.setOnClickListener { payload.onVoiceImageViewClick() }
        viewBinding.itemSearchUserIconImageView.setOnClickListener { payload.onUserTextViewClick() }
        // TODO: アイコンをURLから取得して表示する
        val context = viewBinding.root.context
        viewBinding.itemSearchUserIconImageView.background = ColorDrawable(context.getColor(R.color.purple_200))
    }

    override fun getLayout(): Int {
        return R.layout.item_search
    }

    override fun initializeViewBinding(view: View): ItemSearchBinding {
        return ItemSearchBinding.bind(view)
    }

    override fun unbind(viewHolder: GroupieViewHolder<ItemSearchBinding>) {
        viewHolder.binding.itemSearchSearchIconImageView.setOnClickListener(null)
        viewHolder.binding.itemSearchSearchTextView.setOnClickListener(null)
        viewHolder.binding.itemSearchVoiceIconImageView.setOnClickListener(null)
        viewHolder.binding.itemSearchUserIconImageView.setOnClickListener(null)
        super.unbind(viewHolder)
    }
}
