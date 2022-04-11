package io.github.samples.unidirectionalsampletodo.store.reducer

import io.github.samples.unidirectionalsampletodo.store.State
import io.github.samples.unidirectionalsampletodo.store.Content
import io.github.samples.unidirectionalsampletodo.store.UiState

abstract class Reducer<in T> {
    open fun reduce(action : T, currentState: State) =
        currentState.copy(
            contents = reduceTodoList(action, currentState.contents),
            uiState = reduceUiState(action, currentState.uiState)
        )

    open fun reduceTodoList(action: T, todos: List<Content>): List<Content> = todos

    open fun reduceUiState(action: T, uiState: UiState): UiState =  uiState
}