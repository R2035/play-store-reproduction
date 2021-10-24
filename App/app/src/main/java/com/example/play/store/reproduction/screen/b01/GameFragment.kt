package com.example.play.store.reproduction.screen.b01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.play.store.reproduction.base.BaseFragment
import com.example.play.store.reproduction.databinding.FragmentGameBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : BaseFragment<GameFragmentViewModel, FragmentGameBinding>() {
    override val viewModel: GameFragmentViewModel by viewModel()

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()

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
        requireBinding().gameRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}
