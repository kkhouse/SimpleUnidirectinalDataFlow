package io.github.samples.unidirectionalsampletodo.view

import io.github.samples.unidirectionalsampletodo.store.Store
import io.github.samples.unidirectionalsampletodo.view.userEvent.UserEvent

abstract class ControllerView(
    val store: Store
) {
    abstract fun onEvent(userEvent: UserEvent)
}