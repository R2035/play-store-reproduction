package com.example.play.store.reproduction.base

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * FragmentのViewModelの基底クラス
 * このアプリで実装するFragmentのViewModelは全てこのBaseFragmentを継承させる
 */
abstract class BaseFragmentViewModel : ViewModel() {
    val navDirections: Flow<NavDirections>

    val pop: Flow<Unit>

    private val _navDirections = MutableSharedFlow<NavDirections>()

    private val _pop = MutableSharedFlow<Unit>()

    init {
        navDirections = _navDirections
        pop = _pop
    }

    protected suspend fun transition(navDirections: NavDirections) {
        _navDirections.emit(navDirections)
    }

    protected suspend fun pop() {
        _pop.emit(Unit)
    }
}
