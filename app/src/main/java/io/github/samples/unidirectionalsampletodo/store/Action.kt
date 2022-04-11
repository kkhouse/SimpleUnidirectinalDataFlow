package io.github.samples.unidirectionalsampletodo.store

sealed class Action

sealed class GenerateAction: Action() {
    class GenerateContent: GenerateAction()
}

sealed class LoadAction: Action() {
    data class LoadContent(val todos: List<Content> = emptyList()): LoadAction()
}