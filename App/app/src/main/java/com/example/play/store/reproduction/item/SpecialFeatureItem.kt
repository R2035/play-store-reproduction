package com.example.play.store.reproduction.item

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import com.example.play.store.reproduction.R
import com.example.play.store.reproduction.base.BaseItem
import com.example.play.store.reproduction.databinding.ItemSpecialFeatureBinding
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.GroupieViewHolder

data class SpecialFeatureItem(
    private val id: String,
    val thumbnailImageURL: String,
    val title: String,
    val description: String,
    val link: String,
    val onCardClick: () -> Unit,
    val onLinkClick: () -> Unit,
) : BaseItem<ItemSpecialFeatureBinding, SpecialFeatureItemPayload>(
    id.hashCode().toLong(),
) {
    override fun getPayload(): SpecialFeatureItemPayload {
        return SpecialFeatureItemPayload(
            thumbnailImageURL,
            title,
            description,
            link,
            onCardClick,
            onLinkClick,
        )
    }

    override fun getChange(newItem: Item<*>): SpecialFeatureItemPayload? {
        if (newItem !is SpecialFeatureItem) {
            return null
        }
        return newItem.getPayload()
    }

    override fun update(viewBinding: ItemSpecialFeatureBinding, payload: SpecialFeatureItemPayload) {
        viewBinding.itemSpecialFeatureTitleTextView.text = payload.title
        viewBinding.itemSpecialFeatureCardView.setOnClickListener { payload.onCardClick() }
        viewBinding.itemSpecialFeatureDescriptionTextView.text = payload.description
        viewBinding.itemSpecialFeatureLinkTextView.text = payload.link
        viewBinding.itemSpecialFeatureLinkTextView.setOnClickListener { payload.onLinkClick() }

        // TODO: アイコンをURLから取得して表示する
        viewBinding.itemSpecialFeatureThumbnailImageView.background = ColorDrawable(Color.GRAY)
    }

    override fun getLayout(): Int {
        return R.layout.item_special_feature
    }

    override fun initializeViewBinding(view: View): ItemSpecialFeatureBinding {
        return ItemSpecialFeatureBinding.bind(view)
    }

    override fun unbind(viewHolder: GroupieViewHolder<ItemSpecialFeatureBinding>) {
        viewHolder.binding.itemSpecialFeatureCardView.setOnClickListener(null)
        viewHolder.binding.itemSpecialFeatureLinkTextView.setOnClickListener(null)
        super.unbind(viewHolder)
    }
}
