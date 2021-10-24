package com.example.play.store.reproduction.screen.e01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.play.store.reproduction.base.BaseFragment
import com.example.play.store.reproduction.databinding.FragmentMovieBinding
import com.example.play.store.reproduction.view.StickyHeaderGroupAdapter
import com.jay.widget.StickyHeadersLinearLayoutManager
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * E01 映画&TV
 */
class MovieFragment : BaseFragment<MovieFragmentViewModel, FragmentMovieBinding>() {
    override val viewModel: MovieFragmentViewModel by viewModel()

    private val groupAdapter = StickyHeaderGroupAdapter()

    override fun inflate(inflater: LayoutInflater, root: ViewGroup?, attachToParent: Boolean): FragmentMovieBinding {
        return FragmentMovieBinding.inflate(inflater, root, attachToParent)
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

        requireBinding().movieRecyclerView.adapter = groupAdapter
        requireBinding().movieRecyclerView.layoutManager = StickyHeadersLinearLayoutManager<StickyHeaderGroupAdapter>(requireContext())
    }
}
