package com.example.play.store.reproduction.screen.b01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.play.store.reproduction.base.BaseFragment
import com.example.play.store.reproduction.databinding.FragmentGameBinding
import com.example.play.store.reproduction.view.StickyHeaderGroupAdapter
import com.jay.widget.StickyHeadersLinearLayoutManager
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * B01 ゲーム
 */
class GameFragment : BaseFragment<GameFragmentViewModel, FragmentGameBinding>() {
    override val viewModel: GameFragmentViewModel by viewModel()

    private val groupAdapter = StickyHeaderGroupAdapter()

    override fun inflate(inflater: LayoutInflater, root: ViewGroup?, attachToParent: Boolean): FragmentGameBinding {
        return FragmentGameBinding.inflate(inflater, root, attachToParent)
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

        requireBinding().gameRecyclerView.adapter = groupAdapter
        requireBinding().gameRecyclerView.layoutManager = StickyHeadersLinearLayoutManager<StickyHeaderGroupAdapter>(requireContext())
    }
}
