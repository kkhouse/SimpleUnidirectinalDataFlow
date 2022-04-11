package io.github.samples.unidirectionalsampletodo.store.reducer

import io.github.samples.unidirectionalsampletodo.store.GenerateAction
import io.github.samples.unidirectionalsampletodo.store.UiState

object GenerateReducer: Reducer<GenerateAction>() {
    override fun reduceUiState(action: GenerateAction, uiState: UiState): UiState {
        return when(action) {
            is GenerateAction.GenerateContent -> UiState.Loading
        }
    }
}