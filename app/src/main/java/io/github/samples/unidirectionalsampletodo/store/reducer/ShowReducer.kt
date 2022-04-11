package io.github.samples.unidirectionalsampletodo.store.reducer

import io.github.samples.unidirectionalsampletodo.store.LoadAction
import io.github.samples.unidirectionalsampletodo.store.Content
import io.github.samples.unidirectionalsampletodo.store.UiState

object ShowReducer: Reducer<LoadAction>() {
    override fun reduceTodoList(action: LoadAction, todos: List<Content>): List<Content> {
        return when(action) {
            is LoadAction.LoadContent -> {
                action.todos
            }
        }
    }

    override fun reduceUiState(action: LoadAction, uiState: UiState): UiState {
        return when(action) {
            is LoadAction.LoadContent -> UiState.Show
        }
    }
}