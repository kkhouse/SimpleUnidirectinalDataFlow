package io.github.samples.unidirectionalsampletodo.side_effect

import io.github.samples.unidirectionalsampletodo.side_effect.handler.GenerateHandler
import io.github.samples.unidirectionalsampletodo.store.*

class SideEffectImpl(
    val store: Store,
) : SideEffect() {

    init {
        store.sideEffect = this
    }

    override fun handle(action: Action) {
        when(action) {
            is GenerateAction.GenerateContent -> GenerateHandler.handle(action) { store.dispatch(it) }
            else -> Unit
        }
    }

}
