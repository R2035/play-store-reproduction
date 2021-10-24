package com.example.play.store.reproduction.screen.d01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.play.store.reproduction.base.BaseFragment
import com.example.play.store.reproduction.databinding.FragmentBookBinding
import com.example.play.store.reproduction.view.StickyHeaderGroupAdapter
import com.jay.widget.StickyHeadersLinearLayoutManager
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * D01 書籍
 */
class BookFragment : BaseFragment<BookFragmentViewModel, FragmentBookBinding>() {
    override val viewModel: BookFragmentViewModel by viewModel()

    private val groupAdapter = StickyHeaderGroupAdapter()

    override fun inflate(inflater: LayoutInflater, root: ViewGroup?, attachToParent: Boolean): FragmentBookBinding {
        return FragmentBookBinding.inflate(inflater, root, attachToParent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.sections.collect {
                groupAdapter.update(it)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireBinding().bookRecyclerView.adapter = groupAdapter
        requireBinding().bookRecyclerView.layoutManager = StickyHeadersLinearLayoutManager<StickyHeaderGroupAdapter>(requireContext())
    }
}
