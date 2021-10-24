package com.example.play.store.reproduction.item

import android.view.View
import com.example.play.store.reproduction.R
import com.example.play.store.reproduction.base.BaseItem
import com.example.play.store.reproduction.databinding.ItemSearchBinding
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.GroupieViewHolder

data class SearchItem(
    private val id: SearchItemId,
    val userName: String,
    val onSearchViewClick: () -> Unit,
    val onVoiceImageViewClick: () -> Unit,
    val onUserTextViewClick: () -> Unit,
) : BaseItem<ItemSearchBinding, SearchItemPayload>(
    id.hashCode().toLong(),
) {
    override fun getPayload(): SearchItemPayload {
        return SearchItemPayload(
            userName,
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
        viewBinding.itemSearchUserNameTextView.setOnClickListener { payload.onUserTextViewClick() }
        viewBinding.itemSearchUserNameTextView.text = payload.userName
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
        viewHolder.binding.itemSearchUserNameTextView.setOnClickListener(null)
        super.unbind(viewHolder)
    }
}
