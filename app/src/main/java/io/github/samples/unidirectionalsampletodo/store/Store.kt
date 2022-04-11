package io.github.samples.unidirectionalsampletodo.store

import io.github.samples.unidirectionalsampletodo.store.reducer.ShowReducer
import io.github.samples.unidirectionalsampletodo.store.reducer.GenerateReducer
import kotlinx.coroutines.flow.MutableStateFlow

interface Subscribers {
    val sideEffect: SideEffect?

    fun dispatch(action: Action)
}

abstract class Store(
    override var sideEffect: SideEffect?): Subscribers {

    private var _state = MutableStateFlow( State() )
    val state = _state

    override fun dispatch(action: Action) {
        _state.value = reduce(action, _state.value)
        sideEffect?.handle(action)
    }

    // Navigationやインジケータなどの情報をStateに反映するのが主目的。DBやAPIはSideEffectが担う。
    private fun reduce(action: Action, currentState: State): State {
        return when(action) {
            is LoadAction -> ShowReducer.reduce(action, currentState)
            is GenerateAction -> GenerateReducer.reduce(action, currentState)
        }
    }
}

