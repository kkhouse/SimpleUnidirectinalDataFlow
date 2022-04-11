package io.github.samples.unidirectionalsampletodo.store

enum class UiState {
    Loading,
    Show
}

data class State (
    val contents: List<Content> = emptyList(),
    val uiState: UiState = UiState.Show
)