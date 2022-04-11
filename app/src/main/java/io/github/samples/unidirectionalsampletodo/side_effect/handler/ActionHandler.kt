package io.github.samples.unidirectionalsampletodo.side_effect.handler

import io.github.samples.unidirectionalsampletodo.store.Action

internal interface ActionHandler<in T : Action> {
    fun handle(action: T, actionDispatcher: (Action) -> Unit)
}